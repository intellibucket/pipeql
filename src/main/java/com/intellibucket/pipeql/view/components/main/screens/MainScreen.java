package com.intellibucket.pipeql.view.components.main.screens;

import com.intellibucket.pipeql.lib.bar.GMenuBar;
import com.intellibucket.pipeql.lib.frame.abstracts.MaximizedGFrame;
import com.intellibucket.pipeql.lib.panel.line.LinePanel;
import com.intellibucket.pipeql.lib.panel.side.AbstractSideGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.bars.MainGMenuBar;
import com.intellibucket.pipeql.view.components.main.panel.BottomInfoPanel;
import com.intellibucket.pipeql.view.components.main.panel.HeaderControlPanel;
import com.intellibucket.pipeql.view.components.main.panel.LeftSidePanel;
import com.intellibucket.pipeql.view.components.main.panel.RightSidePanel;

import java.awt.*;
import java.util.List;

public class MainScreen extends MaximizedGFrame  {

    private final GMenuBar mainGMenuBar;
    private final LinePanel headerPanel;
    private final LinePanel bottomPanel;
    private final AbstractSideGPanel leftSidePanel;
    private final AbstractSideGPanel rightSidePanel;

    public MainScreen() {
        this.mainGMenuBar = new MainGMenuBar();
        this.headerPanel = new HeaderControlPanel();
        this.bottomPanel = new BottomInfoPanel();
        this.leftSidePanel = new LeftSidePanel();
        this.rightSidePanel = new RightSidePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainGMenuBar,
                this.headerPanel,
                this.bottomPanel,
                this.leftSidePanel,
                this.rightSidePanel
        );
    }

    @Override
    public void addComponents() {
        this.setJMenuBar(this.mainGMenuBar);
        this.add(this.headerPanel, BorderLayout.NORTH);
        this.add(this.bottomPanel, BorderLayout.SOUTH);
        this.add(this.leftSidePanel, BorderLayout.WEST);
        this.add(this.rightSidePanel, BorderLayout.EAST);
    }

}
