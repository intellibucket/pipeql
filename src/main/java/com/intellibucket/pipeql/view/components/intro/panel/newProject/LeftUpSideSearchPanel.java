package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class LeftUpSideSearchPanel extends ChangeablePanel {
    private final AbstractGTextField projectNameTextField = new SimpleGTextField(20);
    private final AbstractGLabel iconPanel = new SimpleGLabel(IconProvider.getIcon("search@20x20"));
    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {

        return List.of(this.projectNameTextField, this.iconPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.iconPanel, BorderLayout.WEST);
        this.add(this.projectNameTextField, BorderLayout.CENTER);

    }
}
