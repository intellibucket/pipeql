package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.lib.button.AbstractGButton;
import com.intellibucket.pipeql.lib.button.SimpleGButton;
import com.intellibucket.pipeql.lib.button.SimpleIconGButton;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.InnerPanel;
import com.intellibucket.pipeql.lib.panel.LinePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class HeaderControlPanel extends LinePanel {

    private final AbstractGPanel leftPanel;

    private final AbstractGPanel rightPanel;

    public HeaderControlPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
        this.leftPanel = new HeaderLeftPanel();
        this.rightPanel = new HeaderRightPanel();
    }

    public HeaderControlPanel(LayoutManager layout) {
        this(layout, false);
    }

    public HeaderControlPanel(boolean isDoubleBuffered) {
        this(new BorderLayout(), isDoubleBuffered);
    }

    public HeaderControlPanel() {
        this(new BorderLayout());
    }

    public AbstractGPanel getLeftPanel() {
        return leftPanel;
    }

    public AbstractGPanel getRightPanel() {
        return rightPanel;
    }


    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.getLeftPanel(),
                this.getRightPanel()
        );
    }

    @Override
    public void addComponents() {
        this.add(this.getLeftPanel(), BorderLayout.WEST);
        this.add(this.getRightPanel(), BorderLayout.EAST);
    }
}

class HeaderLeftPanel extends InnerPanel {
    private final AbstractGButton simpleGButton = new SimpleIconGButton("SimpleGButton");

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(simpleGButton);
    }

    @Override
    public void addComponents() {
        this.add(simpleGButton);
    }
}

class HeaderRightPanel extends InnerPanel {

    private final AbstractGButton simpleGButton = new SimpleIconGButton("csv");

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(simpleGButton);
    }

    @Override
    public void addComponents() {
        this.add(simpleGButton);
    }

}