package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.BigIconGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
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

    private final AbstractGPanel fourthLine = new TripleButtonPanel();

    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.firstLine,this.secondLine,this.thirdLine,this.fourthLine);
    }

    @Override
    public void addComponents() {
        this.add(this.firstLine);
        this.add(this.secondLine);
        this.add(this.thirdLine);
        this.add(Box.createVerticalStrut(20));
        this.add(this.fourthLine);
    }

    @Override
    public void postInitialize() {
        this.firstLine.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.secondLine.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.thirdLine.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.fourthLine.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    class TripleButtonPanel extends AbstractGPanel{

        private final AbstractGButton newProjectButton = new BigIconGButton("addFolder");
        private final AbstractGButton openProjectButton = new BigIconGButton("menu-open");
        private final AbstractGButton gitButton = new BigIconGButton("vcs@20x20");

        {
            this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        }
        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.newProjectButton,
                    this.openProjectButton,
                    this.gitButton
            );
        }

        @Override
        public void addComponents() {
            this.add(this.newProjectButton);
            this.add(Box.createHorizontalStrut(20));
            this.add(this.openProjectButton);
            this.add(Box.createHorizontalStrut(20));
            this.add(this.gitButton);
        }
    }
}
