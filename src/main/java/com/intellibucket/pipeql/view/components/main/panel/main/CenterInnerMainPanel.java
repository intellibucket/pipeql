package com.intellibucket.pipeql.view.components.main.panel.main;

import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.MainTabbedPane;

import java.awt.*;
import java.util.List;

public class CenterInnerMainPanel extends InnerResizeablePanel {
    private final MainTabbedPane mainTabbedPane = new MainTabbedPane();
    {
        setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.mainTabbedPane);
    }

    @Override
    public void addComponents() {
        add(mainTabbedPane, BorderLayout.CENTER);
    }

    @Override
    public void open() {}
}
