package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.panel.MidGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.EmptyCenterIntroPanel;
import com.intellibucket.pipeql.view.components.intro.panel.LeftSideIntroductionPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class IntroductionScreen extends MidGFrame {

    private final JSplitPane splitPane;
    private final LeftSideIntroductionPanel leftSideIntroductionPanel;
    private final ChangeablePanel changeablePanel;


    {
        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        this.setLocationRelativeTo(null);
    }

    public IntroductionScreen() {
        super("Welcome to PipeQL");
        this.leftSideIntroductionPanel = new LeftSideIntroductionPanel();
        this.changeablePanel = new EmptyCenterIntroPanel();
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftSideIntroductionPanel, this.changeablePanel);
        this.splitPane.setDividerLocation(300);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.leftSideIntroductionPanel,
                this.changeablePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.splitPane);
    }
}
