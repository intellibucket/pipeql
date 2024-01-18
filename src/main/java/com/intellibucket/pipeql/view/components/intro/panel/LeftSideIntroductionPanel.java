package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.BorderlessGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LeftSideIntroductionPanel extends AbstractGPanel {
    private final AbstractGPanel logoHeaderPanel;
    private final AbstractGPanel buttonsListPanel;
    private final AbstractGPanel bottomPanel;

    {
        this.setLayout(new BorderLayout());
    }


    public LeftSideIntroductionPanel() {
        this.logoHeaderPanel = new ApplicationLogoHeaderPanel();
        this.buttonsListPanel = new ButtonsListPanel();
        this.bottomPanel = new BottomPanel();
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.logoHeaderPanel,
                this.buttonsListPanel,
                this.bottomPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.logoHeaderPanel, BorderLayout.NORTH);
        this.add(this.buttonsListPanel, BorderLayout.CENTER);
        this.add(this.bottomPanel, BorderLayout.SOUTH);
    }
}

class ApplicationLogoHeaderPanel extends AbstractGPanel {

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}


class ButtonsListPanel extends AbstractGPanel {
    private final AbstractGButton projectsButton = new BorderlessGButton("Projects");
    private final AbstractGButton learnAbout = new BorderlessGButton("Learn About");

    {
        this.setBackground(Color.BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectsButton,
                this.learnAbout
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectsButton);
        this.add(this.learnAbout);
    }
}

class BottomPanel extends AbstractGPanel {

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}