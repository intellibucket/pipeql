package com.intellibucket.pipeql.lib;

import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class ContextHolder<C> {
    private final Lock lock = new ReentrantLock(Boolean.TRUE);
    private final AtomicInteger currentQueueIndex;
    private final List<Consumer<C>> listeners;
    private final Queue<C> contextQueue;
    private volatile LocalTime lastAccessTime;
    private volatile C context;

    public ContextHolder(C context) {
        this(context, new LinkedList<>());
    }

    public ContextHolder(C context, Consumer<C> listener) {
        this(context, new LinkedList<>(List.of(listener)));
    }

    public ContextHolder(C context, List<Consumer<C>> listeners) {
        this.currentQueueIndex = new AtomicInteger(0);
        this.context = context;
        this.contextQueue = new LinkedList<>();
        this.listeners = listeners;
        this.lastAccessTime = LocalTime.now();
    }

    public Optional<C> getContext() {
        return Optional.ofNullable(this.context);
    }

    public void addListener(Consumer<C> listener) {
        this.listeners.add(listener);
    }

    public void removeListener(Consumer<C> listener) {
        this.listeners.remove(listener);
    }

    public void clearListeners() {
        this.listeners.clear();
    }

    public void notifyListeners() {
        this.listeners.parallelStream()
                .unordered()
                .forEach(listener -> listener.accept(this.context));
    }

    private void updateLastAccessTime() {
        this.lastAccessTime = LocalTime.now();
    }

    public void update(C context) {
        var result = this.lock.tryLock();
        if (result) {
            //TODO: add a check for the same context
            try {
                this.context = context;
                this.contextQueue.add(context);
                this.updateLastAccessTime();
                this.notifyListeners();
                this.currentQueueIndex.incrementAndGet();
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
