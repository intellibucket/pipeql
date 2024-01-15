package com.intellibucket.pipeql.eventlink.model.event.concretes.start;

import com.intellibucket.pipeql.eventlink.model.payload.EmptyPayload;

public class EmptyStartEvent extends StartEvent<EmptyPayload>{
    public EmptyStartEvent(String processName) {
        super(processName);
    }
}
