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
    private List<ColumnRoot> columns;

}
