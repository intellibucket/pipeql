package com.intellibucket.pipeql.eventlink.rx.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmptyCallback implements Callback {
    @Override
    public void onSuccess(SuccessEvent event) {
        log.info("EmptyCallback.onSuccess");
    }

    @Override
    public void onFail(FailureEvent event) {
        log.info("EmptyCallback.onFail");
    }
}
