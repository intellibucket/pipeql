package com.intellibucket.pipeql.eventlink.model.consumer;

import com.intellibucket.pipeql.eventlink.model.common.GroupID;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import lombok.Getter;

@Getter
public record ConsumerAggregate(GroupID groupId, Consumer<?, ?> consumer) {

}
