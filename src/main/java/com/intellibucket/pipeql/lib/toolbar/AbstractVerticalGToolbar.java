package com.intellibucket.pipeql.lib.toolbar;

import javax.swing.*;

public abstract class AbstractVerticalGToolbar extends JToolBar {

    public AbstractVerticalGToolbar() {
    }

    public AbstractVerticalGToolbar(int orientation) {
        super(orientation);
    }

    public AbstractVerticalGToolbar(String name) {
        super(name);
    }

    public AbstractVerticalGToolbar(String name, int orientation) {
        super(name, orientation);
    }
}
