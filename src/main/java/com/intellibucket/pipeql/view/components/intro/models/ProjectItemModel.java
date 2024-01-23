package com.intellibucket.pipeql.view.components.intro.models;

import com.intellibucket.pipeql.view.util.ColorUtils;
import lombok.Getter;

import java.awt.*;

@Getter
public class ProjectItemModel {
    private String projectName;
    private String projectPath;

    private Color color;

    public ProjectItemModel(String projectName, String projectPath ) {
        this.projectName = projectName;
        this.projectPath = projectPath;
        this.color = ColorUtils.randomColor();
    }

}
