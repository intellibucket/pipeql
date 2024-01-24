package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LabelPairPanel extends AbstractGPanel{

    private final AbstractGLabel firstLabel;
    private final AbstractGLabel secondLabel;

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public LabelPairPanel(AbstractGLabel firstLabel, AbstractGLabel secondLabel) {
        this.firstLabel = firstLabel;
        this.secondLabel = secondLabel;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.firstLabel,
                this.secondLabel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.firstLabel);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(this.secondLabel);
    }
}
