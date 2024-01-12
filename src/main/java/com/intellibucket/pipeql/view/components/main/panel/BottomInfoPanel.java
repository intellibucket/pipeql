package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.panel.line.InnerPanel;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

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

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.closePanes
        );
    }

    @Override
    public void addComponents() {
        this.add(this.closePanes);
    }
}

class BottomRightInfoPanel extends InnerPanel {
    private final AbstractGButton lockButton = new SimpleIconGButton("lock");

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.lockButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.lockButton);
    }
}
