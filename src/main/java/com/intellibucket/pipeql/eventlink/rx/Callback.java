package com.intellibucket.pipeql.eventlink.rx;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;

public interface Callback<S extends SuccessPayload,F extends FailPayload> {
    void onSuccess(SuccessEvent event);
    void onFail(FailureEvent event);
}
