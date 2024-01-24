package com.intellibucket.pipeql.domain.model.root;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class ColumnRoot extends BaseRoot{
    private UUID tableId;
    private String name;
    private String description;
    private String dataType;
    private Integer length;
    private Integer precision;
    private Integer scale;
    private Boolean isNullable;
    private Boolean isPrimaryKey;
    private Boolean isForeignKey;
    private Boolean isUnique;
    private Boolean isAutoIncrement;
    private Boolean isIndexed;
    private Boolean isGenerated;
    private Boolean isGeneratedAlways;
    private Boolean isGeneratedByDefault;
    private Boolean isVirtual;
    private Boolean isStored;
    private Boolean isHidden;
    private Boolean isReadOnly;
    private Boolean isUpdatable;
    private Boolean isInsertable;
    private Boolean isDeletable;
    private Boolean isSelectable;
    private Boolean isSearchable;
    private Boolean isCaseSensitive;
}
