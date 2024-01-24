package com.intellibucket.pipeql.lib.frame.abstracts;

import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.Listener;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGFrame extends JFrame  implements ComponentInitializer, Listener {

    private List<EventListener<?,?>> eventListeners;

    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public AbstractGFrame() {
        super();
    }

    public AbstractGFrame(GraphicsConfiguration gc) {
        super(gc);
    }

    public AbstractGFrame(String title) {
        super(title);
    }

    public AbstractGFrame(String title, GraphicsConfiguration gc) {
        super(title, gc);
    }


    @Override
    public void initialize() {
        ComponentInitializer.super.initialize();
        this.setVisible(true);
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
}
