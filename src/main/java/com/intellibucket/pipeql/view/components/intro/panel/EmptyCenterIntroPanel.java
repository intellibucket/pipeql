package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.*;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmptyCenterIntroPanel extends ChangeablePanel {
    private final AbstractGSimplePanel mainPanel = new LabelPanel();

    {
        this.setLayout(new GridBagLayout());
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.mainPanel);
    }
}


class LabelPanel extends AbstractGSimplePanel {
    private final AbstractGPanel firstLine = new BigLabelPanel(new BigInfoGLabel("Welcome to PipeQL"));
    private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Create a new project to start from scratch"), new BlueGLabel(""));
    private final AbstractGPanel thirdLine = new LabelPairPanel(new BigInfoGLabel("Open existing project from disk or version control"), new BlueGLabel(""));

    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.firstLine,this.secondLine,this.thirdLine);
    }

    @Override
    public void addComponents() {
        this.add(this.firstLine);
        this.add(this.secondLine);
        this.add(this.thirdLine);
    }

    @Override
    public void postInitialize() {
        this.firstLine.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.secondLine.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.thirdLine.setLayout(new FlowLayout(FlowLayout.CENTER));
    }
}