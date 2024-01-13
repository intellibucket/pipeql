package com.intellibucket.pipeql.eventlink.rx.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;

public class EmptyCallback implements Callback {
    @Override
    public void onSuccess(SuccessEvent event) {

    }

    @Override
    public void onFail(FailureEvent event) {

    }
}
