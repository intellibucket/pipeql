package com.intellibucket.pipeql.domain.model.root;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class TableRoot extends BaseRoot{
    private UUID schemaId;
    private String name;
    private String description;

    private String comments;
    private List<ColumnRoot> columns;

    @Override
    public <T> Boolean isSameId(T id) {
        return this.getId().equals(id);
    }

    @Override
    public String toString() {
        return "TableRoot{" +
                "schemaId=" + schemaId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", columns size=" + columns.size() +
                '}';
    }
}
