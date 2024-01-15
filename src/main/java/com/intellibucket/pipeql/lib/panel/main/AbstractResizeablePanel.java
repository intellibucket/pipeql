package com.intellibucket.pipeql.lib.panel.main;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class AbstractResizeablePanel extends AbstractGPanel {

    private final InnerResizeablePanel leftPanel;
    private final InnerResizeablePanel centerPanel;
    private final InnerResizeablePanel rightPanel;
    private final JSplitPane leftCenterSplitPanel;
    private final JSplitPane centerRightSplitPanel;

    {
        this.setLayout(new BorderLayout());
    }
    protected AbstractResizeablePanel(InnerResizeablePanel leftPanel,
                                      InnerResizeablePanel centerPanel,
                                      InnerResizeablePanel rightPanel) {
        this.leftPanel = leftPanel;
        this.centerPanel = centerPanel;
        this.rightPanel = rightPanel;
        this.leftCenterSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
        this.centerRightSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftCenterSplitPanel, rightPanel);
        this.leftPanel.setVisible(false);
        this.rightPanel.setVisible(false);
    }

    public void openLeftBar(){
        this.leftPanel.open();
        this.leftCenterSplitPanel.setDividerLocation(0.2);
    }

    public void openRightBar(){
        this.rightPanel.open();
        this.centerRightSplitPanel.setDividerLocation(0.8);
    }
}
