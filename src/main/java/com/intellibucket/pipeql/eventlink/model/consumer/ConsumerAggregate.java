package com.intellibucket.pipeql.eventlink.model.consumer;

import com.intellibucket.pipeql.eventlink.model.common.GroupID;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;

public record ConsumerAggregate(GroupID groupId, EventListener<?, ?> eventListener) {

}
