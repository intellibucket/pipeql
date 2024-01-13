package com.intellibucket.pipeql.eventlink.pipeline.abstracts;

import com.intellibucket.pipeql.eventlink.model.common.Topic;

public interface PipelineRegistration {
    void registerPipeline(Topic topic, Pipeline pipeline);
}
