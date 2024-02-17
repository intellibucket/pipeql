package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.Listener;
import com.intellibucket.pipeql.lib.Refreshable;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGPanel extends JPanel implements ComponentInitializer, Refreshable, Listener {

    private List<EventListener<?,?>> eventListeners;

    public AbstractGPanel(LayoutManager layout, boolean isDoubleBuffered) {
        super(layout, isDoubleBuffered);
    }

    public AbstractGPanel(LayoutManager layout) {
        super(layout);
    }

    public AbstractGPanel(boolean isDoubleBuffered) {
        super(isDoubleBuffered);
    }

    public AbstractGPanel() {
    }

    @Override
    public void refresh() {
        this.removeAll();
        this.initialize();
        this.updateUI();
    }

    @Override
    public void addEventListener(EventListener<? extends Payload,? extends SuccessPayload> eventListener) {
        if (this.eventListeners == null) {
            this.eventListeners = new LinkedList<>(){
                {
                    this.add(eventListener);
                }
            };
        } else {
            this.eventListeners.add(eventListener);
        }
    }

    public List<EventListener<?, ?>> getEventListeners() {
        return eventListeners;
    }
}
