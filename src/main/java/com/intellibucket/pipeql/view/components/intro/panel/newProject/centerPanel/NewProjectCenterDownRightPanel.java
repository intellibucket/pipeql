package com.intellibucket.pipeql.view.components.intro.panel.newProject.centerPanel;

import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public class NewProjectCenterDownRightPanel extends AbstractGSimplePanel {
    private final NewProjectButtonPanel projectCreateAndCancelButtonPanel;

    {
        this.projectCreateAndCancelButtonPanel = new NewProjectButtonPanel();
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectCreateAndCancelButtonPanel);
    }

    @Override
    public void setComponents() {
        this.add(this.projectCreateAndCancelButtonPanel);
    }

}
