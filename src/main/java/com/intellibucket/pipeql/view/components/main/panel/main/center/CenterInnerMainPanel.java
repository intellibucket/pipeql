package com.intellibucket.pipeql.view.components.main.panel.main.center;

import com.intellibucket.pipeql.view.client.main.concretes.MockSchemaItemClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.components.main.tabbedPane.MainTabbedPane;

import java.awt.*;
import java.util.List;

public class CenterInnerMainPanel extends InnerResizeablePanel {
    private final MainTabbedPane mainTabbedPane;

    {
        setLayout(new BorderLayout());
    }

    public CenterInnerMainPanel() {
        this.mainTabbedPane = new MainTabbedPane(MockSchemaItemClient.getProject());
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
