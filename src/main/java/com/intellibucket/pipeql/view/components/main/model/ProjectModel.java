package com.intellibucket.pipeql.view.components.main.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class ProjectModel {
    private String nameOfProject;
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;
    private String createdBy;
    private String description;
    private String version;
    private List<SchemaItemModel> schemas;
}