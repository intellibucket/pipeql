package com.intellibucket.pipeql.view.components.main.panel.main.right;

import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class EmptyChangeableSideBarPanel extends ChangeablePanel {
    private final LabelBox labelBox = new LabelBox();

    {
        this.setLayout(new GridBagLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                labelBox
        );
    }

    @Override
    public void addComponents() {
        this.add(labelBox);
    }
}

class LabelBox extends AbstractGSimplePanel{

    private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Nothing"),new BlueGLabel(""));

    {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                firstLine
        );
    }

    @Override
    public void addComponents() {
        this.add(firstLine);
    }
}