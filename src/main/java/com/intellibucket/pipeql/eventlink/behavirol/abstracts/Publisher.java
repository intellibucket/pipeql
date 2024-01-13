package com.intellibucket.pipeql.eventlink.behavirol.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.abstracts.AbstractEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.producer.Message;
import com.intellibucket.pipeql.eventlink.model.producer.Topic;

public interface Publisher {
    void publish(Message message);
    void onSuccess(SuccessEvent<?> event);
    void onFail(FailEvent<?> event);
}
