package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;

public abstract class AbstractGLabel extends JLabel implements ComponentInitializer {
    public AbstractGLabel() {
    }

    public AbstractGLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public AbstractGLabel(Icon image) {
        super(image);
    }

    public AbstractGLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public AbstractGLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public AbstractGLabel(String text) {
        super(text);
    }
}
