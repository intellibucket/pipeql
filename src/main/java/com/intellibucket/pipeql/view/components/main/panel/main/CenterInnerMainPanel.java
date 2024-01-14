package com.intellibucket.pipeql.view.components.main.panel.main;

import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.MainTabbedPane;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CenterInnerMainPanel extends InnerResizeablePanel {
    private final MainTabbedPane mainTabbedPane = new MainTabbedPane();
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.mainTabbedPane);
    }

    @Override
    public void addComponents() {
        setLayout(new BorderLayout());
        add(mainTabbedPane, BorderLayout.CENTER);
    }

    @Override
    public void open() {}
}
