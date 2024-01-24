package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.rx.concretes.EmptyCallback;
import com.intellibucket.pipeql.lib.button.vertical.AbstractVerticalGButton;
import com.intellibucket.pipeql.lib.button.vertical.SimpleVerticalGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.panel.side.InnerSideGPanel;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractRightSidePanelClient;
import com.intellibucket.pipeql.view.client.main.concretes.RightSidePanelClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class RightSidePanel extends SimpleSideGPanel {
    private final InnerSideGPanel topRightSideInnerPanel;
    private final InnerSideGPanel bottomRightSideInnerPanel;

    public RightSidePanel() {
        this.topRightSideInnerPanel = new TopRightSideInnerPanel();
        this.bottomRightSideInnerPanel = new BottomRightSideInnerPanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.topRightSideInnerPanel,
                this.bottomRightSideInnerPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.topRightSideInnerPanel, BorderLayout.NORTH);
        this.add(this.bottomRightSideInnerPanel, BorderLayout.SOUTH);
    }
}

class BottomRightSideInnerPanel extends InnerSideGPanel {

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}

class TopRightSideInnerPanel extends InnerSideGPanel {

    private final AbstractRightSidePanelClient rightSidePanelClient = new RightSidePanelClient();
    private final AbstractVerticalGButton  notificationButton;

    TopRightSideInnerPanel() {
        this.notificationButton = new SimpleVerticalGButton("", ImageToolKit.getIcon("notifications"));
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.notificationButton
        );
    }

    @Override
    public void addComponents() {
        this.add(this.notificationButton);
    }


    @Override
    public void setActions() {
        this.notificationButton.addActionListener(e -> {
            this.rightSidePanelClient.openNotificationSideBar(EmptyCallback.INSTANCE);
        });
    }
}