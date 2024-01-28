package com.intellibucket.pipeql.domain.model.root;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class SchemaRoot extends BaseRoot{
    private UUID projectId;
    private String name;
    private String description;
    private List<TableRoot> tables;

    @Override
    public <T> Boolean isSameId(T id) {
        return this.getId().equals(id);
    }
}
