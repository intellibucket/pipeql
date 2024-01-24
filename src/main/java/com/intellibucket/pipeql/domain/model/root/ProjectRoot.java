package com.intellibucket.pipeql.domain.model.root;

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
}
