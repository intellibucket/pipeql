package com.intellibucket.pipeql.lib.panel.main;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class AbstractResizeablePanel extends AbstractGPanel {

    private final AbstractInnerResizeablePanel leftPanel;
    private final AbstractInnerResizeablePanel centerPanel;
    private final AbstractInnerResizeablePanel rightPanel;
    private final JSplitPane leftCenterSplitPanel;
    private final JSplitPane centerRightSplitPanel;

    {
        this.setLayout(new BorderLayout());
    }
    protected AbstractResizeablePanel(AbstractInnerResizeablePanel leftPanel,
                                      AbstractInnerResizeablePanel centerPanel,
                                      AbstractInnerResizeablePanel rightPanel) {
        this.leftPanel = leftPanel;
        this.centerPanel = centerPanel;
        this.rightPanel = rightPanel;
        this.leftCenterSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, centerPanel);
        this.centerRightSplitPanel = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftCenterSplitPanel, rightPanel);
        this.leftPanel.setVisible(false);
        this.rightPanel.setVisible(false);
    }
}
