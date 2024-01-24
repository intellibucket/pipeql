package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.line.InnerPanel;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractCenterPanelClient;
import com.intellibucket.pipeql.view.client.main.concretes.CenterPanelClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class BottomInfoPanel extends LinePanel {
    private InnerPanel bottomLeftInfoPanel = new BottomLeftInfoPanel();
    private InnerPanel bottomRightInfoPanel = new BottomRightInfoPanel();

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.bottomLeftInfoPanel,
                this.bottomRightInfoPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.bottomLeftInfoPanel, BorderLayout.WEST);
        this.add(this.bottomRightInfoPanel, BorderLayout.EAST);
    }
}

class BottomLeftInfoPanel extends InnerPanel {
    private final AbstractGButton closePanes = new SimpleIconGButton("colors");
    private final AbstractGLabel processLabel  = new SimpleGLabel("Build completed successfully in 1.5s");

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.closePanes,
                this.processLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.closePanes);
        this.add(this.processLabel);
    }
}

class BottomRightInfoPanel extends InnerPanel {
    private final AbstractCenterPanelClient centerPanelClient = new CenterPanelClient();
    private final AbstractGButton lockButton = new SimpleIconGButton("lock");
    private final AbstractGButton closeAllProjectButton = new SimpleIconGButton("closeHover");

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.lockButton,
                this.closeAllProjectButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.closeAllProjectButton);
        this.add(this.lockButton);
    }

    @Override
    public void setActions() {
        this.closeAllProjectButton.addActionListener(e -> {
            this.centerPanelClient.closeAllSchemas();
        });
    }
}
