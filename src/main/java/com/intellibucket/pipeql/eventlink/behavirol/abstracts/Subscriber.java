package com.intellibucket.pipeql.eventlink.behavirol.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;

public interface Subscriber {
    //TODO: add other methods
    void consume(StartEvent<?> event);
}
