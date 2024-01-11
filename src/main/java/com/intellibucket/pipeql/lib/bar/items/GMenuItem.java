package com.intellibucket.pipeql.lib.bar.items;

import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.ComponentLoader;

import javax.swing.*;

public abstract class GMenuItem extends JMenuItem implements ComponentInitializer {
    public GMenuItem() {
        super();
    }

    public GMenuItem(Icon icon) {
        super(icon);
    }

    public GMenuItem(String text) {
        super(text);
    }

    public GMenuItem(Action a) {
        super(a);
    }

    public GMenuItem(String text, Icon icon) {
        super(text, icon);
    }

    public GMenuItem(String text, int mnemonic) {
        super(text, mnemonic);
    }
}
