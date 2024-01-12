package com.intellibucket.pipeql.lib.toolbar;

import javax.swing.*;

public abstract class SimpleVerticalGToolbar extends AbstractVerticalGToolbar {

    public SimpleVerticalGToolbar() {
    }

    public SimpleVerticalGToolbar(int orientation) {
        super(orientation);
    }

    public SimpleVerticalGToolbar(String name) {
        super(name);
    }

    public SimpleVerticalGToolbar(String name, int orientation) {
        super(name, orientation);
    }
}
