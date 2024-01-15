package com.intellibucket.pipeql.view.components.main.panel.main.center;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmptyInnerMainPanel extends InnerResizeablePanel {
    private final AbstractGPanel emptyLabel = new LabelBox();


    {
        setLayout(new GridBagLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.emptyLabel);
    }

    @Override
    public void addComponents() {
        this.add(this.emptyLabel);
    }
}


class LabelBox extends AbstractGPanel {

    private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Search Everywhere"),new BlueGLabel("Double Shift"));
    private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Go to File"),new BlueGLabel("Ctrl+Shift+N"));
    private final AbstractGPanel thirdLine = new LabelPairPanel(new BigInfoGLabel("Recent Files"),new BlueGLabel("Ctrl+E"));
    private final AbstractGPanel fourthLine = new LabelPairPanel(new BigInfoGLabel("Navigation Bar"),new BlueGLabel("Alt+Home"));
    private final AbstractGPanel fifthLine = new LabelPairPanel(new BigInfoGLabel("Drop files here to open thme"),new BlueGLabel(""));

    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.firstLine,this.secondLine,this.thirdLine,this.fourthLine,this.fifthLine);
    }

    @Override
    public void addComponents() {
        this.add(this.firstLine);
        this.add(this.secondLine);
        this.add(this.thirdLine);
        this.add(this.fourthLine);
        this.add(this.fifthLine);

    }
}