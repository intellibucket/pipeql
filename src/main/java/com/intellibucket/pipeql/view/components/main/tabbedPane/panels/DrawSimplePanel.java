package com.intellibucket.pipeql.view.components.main.tabbedPane.panels;

import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class DrawSimplePanel extends AbstractGSimplePanel {
    {
        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
