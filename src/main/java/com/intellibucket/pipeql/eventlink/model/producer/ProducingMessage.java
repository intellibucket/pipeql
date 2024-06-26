package com.intellibucket.pipeql.eventlink.model.producer;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.EmptyStartEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.eventlink.rx.concretes.EmptyCallback;
import lombok.Getter;

import java.util.Objects;

@Getter
public class ProducingMessage {
    private final Topic topic;
    private final Boolean isBackgroundTask;
    private final Boolean isAsync;
    private final Callback callback;
    private final StartEvent<?> event;

    private ProducingMessage(Builder builder) {
        topic = builder.topic;
        isBackgroundTask = builder.isBackgroundTask;
        isAsync = builder.isAsync;
        callback = builder.callback;
        event = Objects.requireNonNullElse(builder.event, new EmptyStartEvent("unknown_process"));
    }

    @Override
    public String toString() {
        return "ProducingMessage{" +
                "topic=" + topic +
                ", isBackgroundTask=" + isBackgroundTask +
                ", isAsync=" + isAsync +
                ", event=" + event +
                "}";
    }

    public static final class Builder {
        private Topic topic = Topic.SYSTEM;
        private Boolean isBackgroundTask = Boolean.FALSE;
        private Boolean isAsync = Boolean.FALSE;
        private Callback callback = EmptyCallback.INSTANCE;
        private StartEvent<?> event = new EmptyStartEvent("unknown_process");

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder topic(Topic val) {
            topic = Objects.requireNonNullElse(val, Topic.SYSTEM);
            return this;
        }

        public Builder topic(String val) {
            return this.topic(new Topic(val));
        }


        public Builder event(StartEvent<?> val) {
            if (val == null) throw new NullPointerException("Event cannot be null");
            event = val;
            return this;
        }

        public Builder isAsync(Boolean val) {
            isAsync = Objects.requireNonNullElse(val, Boolean.FALSE);
            return this;
        }

        public Builder callback(Callback val) {
            callback = Objects.requireNonNullElse(val, EmptyCallback.INSTANCE);
            return this;
        }

        public Builder isBackgroundTask(Boolean val) {
            isBackgroundTask = Objects.requireNonNullElse(val, Boolean.FALSE);
            return this;
        }

        public ProducingMessage build() {
            return new ProducingMessage(this);
        }
    }
}
