package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class HeaderOfLeftInnerMainPanel extends LinePanel {

    private final LinePanel leftPanel = new LeftPanel();
    private final LinePanel rightPanel = new RightPanel();

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.leftPanel,
                this.rightPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.leftPanel, BorderLayout.WEST);
        this.add(this.rightPanel, BorderLayout.EAST);
    }
}


class LeftPanel extends LinePanel{


    private JLabel label = new JLabel(" Projects");

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.label.setIcon(IconProvider.getIcon("generatedFolder"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {
        this.add(this.label,0);
    }
}

class RightPanel extends LinePanel{

    {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    private final AbstractGButton settingsButton = new SimpleIconGButton("inlaySettings");
    private final AbstractGButton collapseAllButton = new SimpleIconGButton("collapseall");
    private final AbstractGButton expandAllButton = new SimpleIconGButton("expandall");
    private final AbstractGButton focusOpenedButton = new SimpleIconGButton("breakpointLambda");



    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.settingsButton,
                this.collapseAllButton,
                this.expandAllButton,
                this.focusOpenedButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.focusOpenedButton);
        this.add(this.collapseAllButton);
        this.add(this.expandAllButton);
        this.add(this.settingsButton);
    }
}
