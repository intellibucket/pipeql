package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.SuccessEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.lib.button.vertical.AbstractVerticalGButton;
import com.intellibucket.pipeql.lib.button.vertical.SimpleVerticalGButton;
import com.intellibucket.pipeql.lib.file.IconProvider;
import com.intellibucket.pipeql.lib.panel.side.InnerSideGPanel;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractLeftSidePanelClient;
import com.intellibucket.pipeql.view.client.main.concretes.LeftSidePanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

public class LeftSidePanel extends SimpleSideGPanel {


    private final InnerSideGPanel topLeftSideInnerPanel;

    private final InnerSideGPanel bottomLeftSideInnerPanel;

    public LeftSidePanel() {
        this.topLeftSideInnerPanel = new TopLeftSideInnerPanel();
        this.bottomLeftSideInnerPanel = new BottomLeftSideInnerPanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.topLeftSideInnerPanel, this.bottomLeftSideInnerPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.topLeftSideInnerPanel, BorderLayout.NORTH);
        this.add(this.bottomLeftSideInnerPanel, BorderLayout.SOUTH);
    }

}

@Slf4j
class TopLeftSideInnerPanel extends InnerSideGPanel{


    private final AbstractLeftSidePanelClient leftSidePanelClient = new LeftSidePanelClient();

    private final AbstractVerticalGButton projectsButton;
    private final AbstractVerticalGButton environmentButton;
    private final AbstractVerticalGButton schemasButton;

    TopLeftSideInnerPanel() {
        this.projectsButton = new SimpleVerticalGButton("", IconProvider.getIcon("projectStructure"));
        this.environmentButton = new SimpleVerticalGButton("", IconProvider.getIcon("value"));
        this.schemasButton = new SimpleVerticalGButton("", IconProvider.getIcon("json"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.projectsButton,this.environmentButton,this.schemasButton);
    }

    @Override
    public void addComponents() {
        this.add(this.projectsButton);
        this.add(this.environmentButton);
        this.add(this.schemasButton);
    }

    @Override
    public void setActions() {
        this.projectsButton.addActionListener(e -> {
            var callback = new Callback() {
                @Override
                public void onSuccess(SuccessEvent event) {
                    log.info("Success Response with transaction id: {}", event.getTransactionId());
                    var payload = (MainResizeablePanel.ProjectButtonListener.ListenerProjectButtonSuccessPayload) event.getPayload();
                }

                @Override
                public void onFail(FailureEvent event) {
                    log.error("Failure Response with transaction id: {}", event.getTransactionId());
                }
            };
            this.leftSidePanelClient.openDatabasesScreen(callback);
        });
    }
}

class BottomLeftSideInnerPanel extends InnerSideGPanel{

    private final AbstractVerticalGButton dataSourcesButton;

    BottomLeftSideInnerPanel() {
        this.dataSourcesButton = new SimpleVerticalGButton("", IconProvider.getIcon("sql"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.dataSourcesButton);
    }

    @Override
    public void addComponents() {
        this.add(this.dataSourcesButton);
    }
}