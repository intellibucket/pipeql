package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class NewProjectCenterPanel extends ChangeablePanel {
    private final AbstractGLabel projectNameLabel;

    private final AbstractGTextField projectNameTextField;
    {
        setLayout(new FlowLayout());
        this.projectNameLabel = new SimpleGLabel("Name:");
        this.projectNameTextField = new SimpleGTextField(20);
        setSize(300, 100);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectNameLabel, this.projectNameTextField);
    }

    @Override
    public void addComponents() {
        this.add(this.projectNameLabel);
        this.add(this.projectNameTextField);
    }


}
