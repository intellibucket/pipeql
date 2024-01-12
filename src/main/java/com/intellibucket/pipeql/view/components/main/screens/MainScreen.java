package com.intellibucket.pipeql.view.components.main.screens;

import com.intellibucket.pipeql.lib.bar.GMenuBar;
import com.intellibucket.pipeql.lib.frame.abstracts.MaximizedGFrame;
import com.intellibucket.pipeql.lib.panel.LinePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.bars.MainGMenuBar;
import com.intellibucket.pipeql.view.components.main.panel.HeaderControlPanel;

import java.awt.*;
import java.util.List;

public class MainScreen extends MaximizedGFrame  {

    private final GMenuBar mainGMenuBar;
    private final LinePanel headerPanel;

    public MainScreen() {
        this.mainGMenuBar = new MainGMenuBar();
        this.headerPanel = new HeaderControlPanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainGMenuBar,
                this.headerPanel
        );
    }

    @Override
    public void addComponents() {
        this.setJMenuBar(this.mainGMenuBar);
        this.add(this.headerPanel, BorderLayout.NORTH);
    }

}
