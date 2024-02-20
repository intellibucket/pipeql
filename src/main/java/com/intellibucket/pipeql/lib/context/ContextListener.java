package com.intellibucket.pipeql.lib.context;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.UUID;

@Slf4j
public abstract class ContextListener<C> {
    private final UUID id = UUID.randomUUID();

    public final void onChange(C context){
        log.info("Invoking onStateChange with id: {}", id);
        this.onStateChange(context);
    }

    protected abstract void onStateChange(C context);

    public final void successChangeState(C context){
        log.info("Invoking onSuccessChangeState with id: {}", id);
        this.onSuccessChangeState(context);
    }

    protected void onSuccessChangeState(C context){
        log.warn("onSuccessChangeState not implemented with id: {}", id);
    }

    public final void errorChangeState(C context){
        log.info("Invoking onErrorChangeState with id: {}", id);
        this.onErrorChangeState(context);
    }

    protected void onErrorChangeState(C context){
        log.warn("onErrorChangeState not implemented with id: {}", id);
    }

    public final void dispose(List<ContextListener<C>> listeners){
        log.info("Disposing listener with id: {}", id);
        listeners.remove(this);
        this.onDispose();
    }

    public void onDispose(){
        log.warn("onDispose not implemented with id: {}", id);
    }

}
