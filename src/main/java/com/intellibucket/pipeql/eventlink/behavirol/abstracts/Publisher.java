package com.intellibucket.pipeql.eventlink.behavirol.abstracts;

import com.intellibucket.pipeql.eventlink.model.event.concretes.FailEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;

public interface Publisher {
    void publish(ProducingMessage message);
    void onSuccess(SuccessEvent event);
    void onFail(FailEvent event);
}
