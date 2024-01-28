package com.intellibucket.pipeql.eventlink.rx.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;


public interface OnlyFailCallback extends Callback{
    @Override
    default void onSuccess(SuccessEvent event) {}
}
