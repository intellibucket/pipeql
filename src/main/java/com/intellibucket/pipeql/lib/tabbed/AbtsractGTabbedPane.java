package com.intellibucket.pipeql.lib.tabbed;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;

public abstract class AbtsractGTabbedPane extends JTabbedPane implements ComponentInitializer {
    public AbtsractGTabbedPane() {
    }

    public AbtsractGTabbedPane(int tabPlacement) {
        super(tabPlacement);
    }

    public AbtsractGTabbedPane(int tabPlacement, int tabLayoutPolicy) {
        super(tabPlacement, tabLayoutPolicy);
    }
}
