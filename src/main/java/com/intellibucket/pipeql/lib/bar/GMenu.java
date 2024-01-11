package com.intellibucket.pipeql.lib.bar;

import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.ComponentLoader;

import javax.swing.*;

public abstract class GMenu extends JMenu implements ComponentInitializer {

    public GMenu(String s) {
        super(s);
    }

    public GMenu(Action a) {
        super(a);
    }

    public GMenu(String s, boolean b) {
        super(s, b);
    }
}
