package com.intellibucket.pipeql.eventlink.pipeline.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;

public interface Pipeline {
    void send(AbstractEvent<?> event);
    void subscribe(Consumer consumer);
}
