package com.intellibucket.pipeql.lib.panel.stateful;


import com.intellibucket.pipeql.mgui.Flow;
import com.intellibucket.pipeql.mgui.State;

import java.util.List;

public abstract class StatefulGPanel <S extends State>  {
    protected final Flow.Subscription subscription;
    private S state;

    {
        //register MGUI
    }

    public StatefulGPanel(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscriber().onSubscribe(this.subscription);
    }

    public void setState(S state){
        this.state = state;
        this.publish();
    }

    public void consume(S state){
        this.subscriber().onNext(state);
    }

    // Publish state to MGUI
    public void publish(){

    }

    public abstract Flow.Subscriber<S> subscriber();
}
