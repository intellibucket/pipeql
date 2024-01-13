package com.intellibucket.pipeql.eventlink.behavirol.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.payload.FailPayload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;

public interface Callback<S extends SuccessPayload,F extends FailPayload> {
    void onSuccess(SuccessEvent event);
    void onFail(FailEvent event);
}
