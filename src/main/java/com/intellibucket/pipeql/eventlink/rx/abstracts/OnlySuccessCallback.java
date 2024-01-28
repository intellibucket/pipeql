package com.intellibucket.pipeql.eventlink.rx.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;

public interface OnlySuccessCallback extends Callback{
    @Override
    default void onFail(FailureEvent event) {}
}
