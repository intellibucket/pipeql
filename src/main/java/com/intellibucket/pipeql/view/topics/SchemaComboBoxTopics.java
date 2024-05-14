package com.intellibucket.pipeql.view.topics;

import com.intellibucket.pipeql.eventlink.model.common.Topic;

public class SchemaComboBoxTopics {
    public static final Topic CHANGED_SELECTED_SCHEMA_ON_COMBOBOX = Topic.of("on-schema-combo-box-changed");

    public record ChangedSelectedSchemaOnCombobox_Topic(){}
}
