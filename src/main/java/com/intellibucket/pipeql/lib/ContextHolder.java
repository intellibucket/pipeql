package com.intellibucket.pipeql.lib;

import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Consumer;

public class ContextHolder<C> {
    private List<Consumer<C>> listeners;
    private final Queue<C> contextQueue;
    private final Lock lock = new ReentrantLock();
    private LocalTime lastAccessTime = LocalTime.now();
    private volatile C context;

    public ContextHolder(C context) {
        this.context = context;
        this.contextQueue = new LinkedList<>();
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

    public void notifyListeners() {
        this.listeners.parallelStream()
                .unordered()
                .forEach(listener -> listener.accept(this.context));
    }

    private void updateLastAccessTime() {
        this.lastAccessTime = LocalTime.now();
    }

    public void change(C context) {
        this.lock.lock();
        try {
            this.context = context;
            this.contextQueue.add(context);
            this.updateLastAccessTime();
        } finally {
            this.lock.unlock();
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
                return Optional.of(this.context);
            }
            return Optional.empty();
        } finally {
            this.lock.unlock();
        }
    }

}
