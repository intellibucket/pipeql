package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.BorderlessGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.SimplePanel;
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
        this.setBackground(new Color(59,63,65));
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

    private final AbstractGPanel panel = new NameVersionPanel();

    {
        this.setBackground(new Color(59,63,65));
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
        this.add(this.panel, BorderLayout.EAST);
    }

    class NameVersionPanel extends AbstractGSimplePanel{
        private AbstractGLabel nameApp = new SimpleGLabel("PipeQL");
        private AbstractGLabel versionApp = new SimpleGLabel("2024.1.1");

        {
            this.nameApp.setFont(new Font("Helvetica", Font.BOLD, 23));
            this.setBackground(new Color(59,63,65));
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
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        this.setOpaque(true);
        this.setBackground(new Color(59,63,65));
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

    {
        this.setBackground(new Color(59,63,65));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}