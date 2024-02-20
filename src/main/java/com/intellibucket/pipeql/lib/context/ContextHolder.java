package com.intellibucket.pipeql.lib.context;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ContextHolder<C> {

    private final Lock lock = new ReentrantLock(Boolean.TRUE);

    private final AtomicInteger currentQueueIndex;

    private final List<ContextListener<C>> listeners;

    private final Queue<C> contextQueue;

    private volatile LocalTime lastAccessTime;

    private volatile C context;

    public ContextHolder(C context) {
        this(context, new LinkedList<>());
    }

    public ContextHolder(C context, ContextListener<C> listener) {
        this(context, new LinkedList<>(List.of(listener)));
    }

    public ContextHolder(C context, List<ContextListener<C>> listeners) {
        this.currentQueueIndex = new AtomicInteger(0);
        this.context = context;
        this.contextQueue = new LinkedList<>();
        this.listeners = listeners;
        this.lastAccessTime = LocalTime.now();
    }

    public Optional<C> getContext() {
        return Optional.ofNullable(this.context);
    }

    public void subscribe(ContextListener<C> listener) {
        this.listeners.add(listener);
    }

    public void dispose(ContextListener<C> listener) {
        listener.dispose(this.listeners);
    }

    public void clearSubscribers() {
        this.listeners.clear();
    }

    public void notifyListeners() {
        this.listeners.parallelStream()
                .unordered()
                .forEach(listener -> {
                    try {
                        listener.onChange(this.context);
                        listener.onSuccessChangeState(this.context);
                    } catch (Exception e) {
                        log.error("Error while notifying listener", e);
                        listener.onErrorChangeState(this.context);
                    }
                });
    }

    private void updateLastAccessTime() {
        this.lastAccessTime = LocalTime.now();
    }

    public void setState(C context) {
        var result = this.lock.tryLock();
        if (result) {
            if (this.context.equals(context)) {
                this.lock.unlock();
                return;
            }
            try {
                this.context = context;
                this.contextQueue.add(context);
                this.updateLastAccessTime();
                this.currentQueueIndex.incrementAndGet();
                this.notifyListeners();
            } finally {
                this.lock.unlock();
            }
        }
    }

    public void clearQueue(C context) {
        this.contextQueue.clear();
    }

    public Optional<C> undo() {
        this.lock.lock();
        try {
            if (this.contextQueue.size() > 1) {
                this.contextQueue.poll();
                this.context = this.contextQueue.peek();
                this.updateLastAccessTime();
                this.currentQueueIndex.decrementAndGet();
                this.notifyListeners();
                return Optional.of(this.context);
            }
            return Optional.empty();
        } finally {
            this.lock.unlock();
        }
    }

    public Optional<C> redo() {
        this.lock.lock();
        try {
            if (this.contextQueue.size() > 1) {
                this.context = this.contextQueue.poll();
                this.context = this.contextQueue.peek();
                this.updateLastAccessTime();
                this.currentQueueIndex.incrementAndGet();
                this.notifyListeners();
                return Optional.of(this.context);
            }
            return Optional.empty();
        } finally {
            this.lock.unlock();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ContextHolder<?> that)) return false;
        return Objects.equals(getContext(), that.getContext());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getContext());
    }

    public LocalTime getLastAccessTime() {
        return lastAccessTime;
    }
}
