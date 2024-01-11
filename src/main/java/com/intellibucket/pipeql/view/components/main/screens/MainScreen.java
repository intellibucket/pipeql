package com.intellibucket.pipeql.view.components.main.screens;

import com.intellibucket.pipeql.lib.bar.GMenuBar;
import com.intellibucket.pipeql.lib.frame.abstracts.MaximizedGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.bars.MainGMenuBar;

import java.util.List;

public class MainScreen extends MaximizedGFrame  {

    private final GMenuBar mainGMenuBar;

    public MainScreen() {
        this.mainGMenuBar = new MainGMenuBar();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.mainGMenuBar);
    }

    @Override
    public void addComponents() {
        this.setJMenuBar(this.mainGMenuBar);
    }

}
