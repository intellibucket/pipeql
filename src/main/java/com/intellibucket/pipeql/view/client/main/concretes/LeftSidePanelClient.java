package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractLeftSidePanelClient;
import com.intellibucket.pipeql.view.components.databases.screen.DatabasesScreen;
import com.intellibucket.pipeql.view.components.main.panel.LeftSidePanel;
import com.intellibucket.pipeql.view.topics.LeftMainPanelTopics;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class LeftSidePanelClient implements AbstractLeftSidePanelClient {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;

    @Override
    public void openProjectsLeftBarScreen(Callback callback) {
        log.info("LeftSidePanelClient.openProjectsLeftBarScreen");
        var message = ProducingMessage.Builder
                .builder()
                .topic(LeftMainPanelTopics.CLICKED_SIDE_PROJECTS_BUTTON)
                .callback(callback)
                .event(new StartEvent<>("Start"))
                .build();
        eventLinkTemplate.publish(message);
    }

    @Override
    public void openSettingsScreen(Callback callback) {

    }

    @Override
    public void openDatabasesScreen(Callback callback) {
        var databasesPanel = new DatabasesScreen();
        databasesPanel.initialize();
    }

    @Override
    public void openQueryScreen(Callback callback) {

    }

    @Override
    public void openDataSetScreen(Callback callback) {

    }

    @Override
    public void openDataTypesScreen(Callback callback) {

    }

}
