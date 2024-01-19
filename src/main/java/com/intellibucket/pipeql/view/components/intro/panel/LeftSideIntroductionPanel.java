package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.BorderlessGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
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
        //this.setBackground(new Color(59,63,65));
    }


    public LeftSideIntroductionPanel() {
        this.logoHeaderPanel = new LagApplicationLogoHeaderPanel();
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

class ApplicationLogoHeaderPanel extends AbstractGPanel {

    private final AbstractGPanel panel = new NameVersionPanel();
    private final AbstractGLabel logo = new SimpleGLabel(IconProvider.getLogo());

    {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.logo,
                this.panel
        );
    }

    @Override
    public void addComponents() {
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(this.logo);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(this.panel);
        this.add(Box.createRigidArea(new Dimension(30, 0)));
    }

    class NameVersionPanel extends AbstractGSimplePanel{
        private AbstractGLabel nameApp = new SimpleGLabel("PipeQL");
        private AbstractGLabel versionApp = new SimpleGLabel("2024.1.1");

        {
            this.nameApp.setFont(new Font("Raleway", Font.BOLD, 23));
            //this.setBackground(new Color(59,63,65));
            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        }
        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.nameApp,
                    this.versionApp
            );
        }

        @Override
        public void addComponents() {
            this.add(this.nameApp);
            this.add(this.versionApp);
        }
    }
}


class ButtonsListPanel extends AbstractGPanel {
    private final AbstractGButton projectsButton = new BorderlessGButton("Projects");
    private final AbstractGButton learnAbout = new BorderlessGButton("Learn About");

    {
        this.setLayout(new GridLayout(16, 1, 0, 0));
        //this.setBackground(new Color(59,63,65));
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

    @Override
    public void postInitialize() {
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
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