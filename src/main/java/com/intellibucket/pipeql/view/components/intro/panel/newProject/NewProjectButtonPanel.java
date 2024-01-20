package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectButtonPanel extends AbstractGSimplePanel {
    private final NewProjectCreateAndCancelButtonPanel projectCreateAndCancelButtonPanel;

    {
        this.projectCreateAndCancelButtonPanel = new NewProjectCreateAndCancelButtonPanel();
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectCreateAndCancelButtonPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.projectCreateAndCancelButtonPanel);
    }

}
