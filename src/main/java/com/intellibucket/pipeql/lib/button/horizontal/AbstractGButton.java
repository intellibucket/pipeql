package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;

public abstract class AbstractGButton extends JButton implements ComponentInitializer {

    {
        this.setFocusPainted(false);
    }
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
