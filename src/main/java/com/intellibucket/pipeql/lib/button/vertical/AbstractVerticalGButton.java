package com.intellibucket.pipeql.lib.button.vertical;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;

public abstract class AbstractVerticalGButton extends JButton implements ComponentInitializer {
    public AbstractVerticalGButton() {
    }

    public AbstractVerticalGButton(Icon icon) {
        super(icon);
    }

    public AbstractVerticalGButton(String text) {
        super(text);
    }

    public AbstractVerticalGButton(Action a) {
        super(a);
    }

    public AbstractVerticalGButton(String text, Icon icon) {
        super(text, icon);
    }
}
