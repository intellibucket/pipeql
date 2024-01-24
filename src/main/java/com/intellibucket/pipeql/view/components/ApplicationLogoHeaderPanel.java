package com.intellibucket.pipeql.view.components;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ApplicationLogoHeaderPanel extends TransparentGPanel {

    private final NameVersionPanel nameVersionPanel = new NameVersionPanel();
    private final AbstractGLabel logo;

    public ApplicationLogoHeaderPanel(){
        this.logo = new SimpleGLabel(ImageToolKit.getLogo());
    }

    {
        this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.logo,
                this.nameVersionPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(Box.createRigidArea(new Dimension(5, 0)));
        this.add(this.logo);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(this.nameVersionPanel);
        this.add(Box.createRigidArea(new Dimension(30, 0)));
    }

    public NameVersionPanel getNameVersionPanel() {
        return nameVersionPanel;
    }

    public AbstractGLabel getLogo() {
        return logo;
    }

    public class NameVersionPanel extends TransparentGPanel {
        private AbstractGLabel applicationNameLabel = new SimpleGLabel("PipeQL");
        private AbstractGLabel applicationVersionLabel = new SimpleGLabel("2024.1.1");

        {
            this.applicationNameLabel.setFont(new Font("Raleway", Font.BOLD, 23));
            this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        }

        public AbstractGLabel getApplicationNameLabel() {
            return applicationNameLabel;
        }

        public AbstractGLabel getApplicationVersionLabel() {
            return applicationVersionLabel;
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.applicationNameLabel,
                    this.applicationVersionLabel
            );
        }

        @Override
        public void addComponents() {
            this.add(this.applicationNameLabel);
            this.add(this.applicationVersionLabel);
        }
    }
}
