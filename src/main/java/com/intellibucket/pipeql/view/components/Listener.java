package com.intellibucket.pipeql.view.components;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;

public interface Listener {
    void addEventListener(com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener<? extends Payload,? extends SuccessPayload> eventListener);
}
