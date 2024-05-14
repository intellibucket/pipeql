package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SimpleValueLabelPanel extends AbstractGPanel {
    private AbstractGLabel label;
    private AbstractGLabel value;

    {
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
    }

    public SimpleValueLabelPanel(String label, String value) {
        this.label = new SimpleGLabel(label);
        this.label.setFont(new Font("Helvetica", Font.PLAIN, 13));
        this.value = new SimpleGLabel(value);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.value
                ,this.label
        );
    }

    @Override
    public void addEventListener(EventListener<? extends Payload, ? extends SuccessPayload> eventListener) {
        super.addEventListener(eventListener);
    }

    @Override
    public void setComponents() {
        this.add(this.label);
        this.add(Box.createRigidArea(new Dimension(10, 0)));
        this.add(this.value);
    }

}
