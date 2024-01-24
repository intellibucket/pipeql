package com.intellibucket.pipeql.view.components.databases.panel.center;

import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmptyCenterDatabasesPanel extends ChangeablePanel {
    private final AbstractGSimplePanel mainPanel = new LabelPanel();

    {
        this.setLayout(new GridBagLayout());
        this.mainPanel.setLayout(new BoxLayout(this.mainPanel, BoxLayout.Y_AXIS));
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.mainPanel);
    }
}


class LabelPanel extends AbstractGSimplePanel {
    private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Search Everywhere"),new BlueGLabel("Ctrl+Shift+F"));
    private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("OK for saving changes and closing"),new BlueGLabel("Ctrl+Shift+O"));
    private final AbstractGPanel fourthLine = new LabelPairPanel(new BigInfoGLabel("Cancel for closing"),new BlueGLabel("Ctrl+Shift+C"));
    private final AbstractGPanel fifthLine = new LabelPairPanel(new BigInfoGLabel("Apply for saving changes"),new BlueGLabel("Ctrl+Shift+S"));

    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.firstLine,this.secondLine,this.fourthLine,this.fifthLine);
    }

    @Override
    public void setComponents() {
        this.add(this.firstLine);
        this.add(this.secondLine);
        this.add(this.fourthLine);
        this.add(this.fifthLine);
    }
}