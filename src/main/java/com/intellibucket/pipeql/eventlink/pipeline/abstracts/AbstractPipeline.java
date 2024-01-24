package com.intellibucket.pipeql.eventlink.pipeline.abstracts;

import com.intellibucket.pipeql.eventlink.model.common.GroupID;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractPipeline implements Pipeline{
    private final Topic topic;
    private final Map<GroupID, EventListener<?,?>> groupingConsumers = new HashMap<>();

    public AbstractPipeline(Topic topic) {
        this.topic = topic;
    }

    public Topic topic() {
        return topic;
    }

    public Map<GroupID, EventListener<?,?>> groupingConsumers() {
        return groupingConsumers;
    }
}
