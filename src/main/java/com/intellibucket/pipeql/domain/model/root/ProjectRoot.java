package com.intellibucket.pipeql.domain.model.root;

import com.intellibucket.pipeql.domain.model.valueo.ProjectID;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProjectRoot extends BaseRoot{
    private String name;
    private String description;
    private String owner;
    private String ownerEmail;
    private List<SchemaRoot> schemas;

    @Override
    public <T> Boolean isSameId(T id) {
        return this.getId().equals(id);
    }
}
