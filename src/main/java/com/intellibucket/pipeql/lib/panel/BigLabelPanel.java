package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class BigLabelPanel extends AbstractGPanel{

    private final AbstractGLabel firstLabel;

    {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    public BigLabelPanel(AbstractGLabel firstLabel) {
        this.firstLabel = firstLabel;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.firstLabel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.firstLabel);
    }

    @Override
    public void postInitialize() {
        this.firstLabel.setFont(new Font("Roboto", Font.BOLD, 32));
        this.firstLabel.setForeground(Color.WHITE);
    }
}
