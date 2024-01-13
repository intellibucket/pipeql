package com.intellibucket.pipeql.eventlink.model.producer;

import com.intellibucket.pipeql.eventlink.model.event.concretes.StartEvent;

public class Message {
    private final Topic topic;
    private final Group group;
    private final Boolean isAsync;
    private final StartEvent<?> event;

    private Message(Builder builder) {
        topic = builder.topic;
        group = builder.group;
        isAsync = builder.isAsync;
        event = builder.event;
    }


    public static final class Builder {
        private Topic topic;
        private Group group;
        private Boolean isAsync = Boolean.FALSE;
        private StartEvent<?> event;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder topic(Topic val) {
            topic = val;
            return this;
        }

        public Builder group(Group val) {
            group = val;
            return this;
        }

        public Builder event(StartEvent<?> val) {
            event = val;
            return this;
        }

        public Builder isAsync(Boolean val) {
            isAsync = val;
            return this;
        }

        public Message build() {
            return new Message(this);
        }
    }
}
