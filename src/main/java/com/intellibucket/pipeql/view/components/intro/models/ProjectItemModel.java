package com.intellibucket.pipeql.view.components.intro.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectItemModel {
    private String projectName;
    private String projectPath;

    public ProjectItemModel(String projectName, String projectPath ) {
        this.projectName = projectName;
        this.projectPath = projectPath;
    }

}
