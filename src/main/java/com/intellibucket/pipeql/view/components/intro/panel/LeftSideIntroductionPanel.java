package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.BorderlessGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.view.client.intro.abstracts.AbstractIntroChangeableCenterPanelClient;
import com.intellibucket.pipeql.view.client.intro.concretes.IntroChangeableCenterPanelClient;
import com.intellibucket.pipeql.view.components.ApplicationLogoHeaderPanel;
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
        this.logoHeaderPanel = new LagApplicationLogoHeaderPanel();
        this.buttonsListPanel = new CenterLeftPanel();
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

class LagApplicationLogoHeaderPanel extends AbstractGPanel{

    private final ApplicationLogoHeaderPanel panel = new ApplicationLogoHeaderPanel();

    {
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.panel
        );
    }

    @Override
    public void addComponents() {
        this.add(Box.createRigidArea(new Dimension(15, 0)), BorderLayout.WEST);
        this.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.NORTH);
        this.add(this.panel, BorderLayout.CENTER);
        this.add(Box.createRigidArea(new Dimension(0, 20)), BorderLayout.SOUTH);
    }
}

class CenterLeftPanel extends AbstractGPanel {
    private final AbstractGPanel buttonsPanel  = new ButtonsListPanel();
    private final AbstractGPanel problemsPanel = new ProblemsPanel();


    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.buttonsPanel,
                this.problemsPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.buttonsPanel, BorderLayout.NORTH);
        this.add(this.problemsPanel, BorderLayout.SOUTH);
    }
}

class ProblemsPanel extends AbstractGPanel{
    private final AbstractGLabel problemsLabel =
            new BlueGLabel("Problems",new Font("Arial", Font.PLAIN, 14));

    {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.problemsLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.problemsLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.problemsLabel);
    }
}

class ButtonsListPanel extends AbstractGPanel {
    private final AbstractIntroChangeableCenterPanelClient introChangeableCenterPanelClient = new IntroChangeableCenterPanelClient();
    private final AbstractGButton projectsButton = new BorderlessGButton("Projects");
    private final AbstractGButton customizeButton = new BorderlessGButton("Customize");
    private final AbstractGButton learnAbout = new BorderlessGButton("Learn About");

    {
        this.setLayout(new GridLayout(16, 1, 0, 0));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.projectsButton,
                this.customizeButton,
                this.learnAbout
        );
    }

    @Override
    public void addComponents() {
        this.add(this.projectsButton);
        this.add(this.customizeButton);
        this.add(this.learnAbout);
    }

    @Override
    public void setActions() {
        this.projectsButton.addActionListener(e -> {
            this.introChangeableCenterPanelClient.openProjects();
        });
    }

    @Override
    public void postInitialize() {
        this.setActions();
        this.getComponentInitializers().forEach(
                item-> ((JButton) item).setHorizontalAlignment(SwingConstants.LEFT)
        );
    }
}

class BottomPanel extends AbstractGPanel {
    private final AbstractGButton settingsButton = new SimpleIconGButton("inlaySettings");
    private final AbstractGButton infoButton = new SimpleIconGButton("infoOutline");

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.settingsButton,
                this.infoButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.infoButton);
        this.add(this.settingsButton);
    }
}