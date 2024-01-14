package com.intellibucket.pipeql.view.components.main.panel.main.left;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class HeaderOfLeftInnerMainPanel extends LinePanel {

    private final AbstractGButton settingsButton = new SimpleIconGButton("inlaySettings");
    private final AbstractGButton collapseAllButton = new SimpleIconGButton("collapseall");
    private final AbstractGButton expandAllButton = new SimpleIconGButton("expandall");
    private final AbstractGButton focusOpenedButton = new SimpleIconGButton("breakpointLambda");

    {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

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
