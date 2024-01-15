package com.intellibucket.pipeql.view.components.databases.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class BottomDatabasePanel extends AbstractGSimplePanel {
    private AbstractGSimplePanel leftPanel;
    private AbstractGSimplePanel rightPanel;

    {
        this.setLayout(new BorderLayout());
    }

    public BottomDatabasePanel(){
        this.leftPanel = new LeftBottomDatabasePanel();
        this.rightPanel = new RightBottomDatabasePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftPanel, this.rightPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.leftPanel, BorderLayout.WEST);
        this.add(this.rightPanel, BorderLayout.EAST);
    }
}


class LeftBottomDatabasePanel extends AbstractGSimplePanel {

    private AbstractGButton infoButton;

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public LeftBottomDatabasePanel(){
        this.infoButton = new SimpleIconGButton("questionDialog");
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.infoButton);
    }

    @Override
    public void addComponents() {
        this.add(this.infoButton);
    }
}


class RightBottomDatabasePanel extends AbstractGSimplePanel {

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}