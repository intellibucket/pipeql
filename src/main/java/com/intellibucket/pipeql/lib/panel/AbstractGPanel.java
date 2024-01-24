package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.view.Refreshable;
import com.intellibucket.pipeql.view.components.ActionInitializer;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.Listener;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class AbstractGPanel extends JPanel implements ComponentInitializer, ActionInitializer, Refreshable, Listener {

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
    public void postInitialize() {
        this.setActions();
    }

    @Override
    public void refresh() {
        this.removeAll();
        this.addComponents();
        this.initialize();
        this.updateUI();
    }

    @Override
    public void addEventListener(EventListener<? extends Payload,? extends SuccessPayload> eventListener) {
        if (this.eventListeners == null) {
            this.eventListeners = List.of(eventListener);
        } else {
            this.eventListeners.add(eventListener);
        }
    }

    public List<EventListener<?, ?>> getEventListeners() {
        return eventListeners;
    }

    public  void setEventListeners() {}
}
