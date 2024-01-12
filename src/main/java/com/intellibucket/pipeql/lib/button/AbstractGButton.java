package com.intellibucket.pipeql.lib.button;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;

public abstract class AbstractGButton extends JButton implements ComponentInitializer {

    public AbstractGButton() {
    }

    public AbstractGButton(Icon icon) {
        super(icon);
    }

    public AbstractGButton(String text) {
        super(text);
    }

    public AbstractGButton(Action a) {
        super(a);
    }

    public AbstractGButton(String text, Icon icon) {
        super(text, icon);
    }
}
