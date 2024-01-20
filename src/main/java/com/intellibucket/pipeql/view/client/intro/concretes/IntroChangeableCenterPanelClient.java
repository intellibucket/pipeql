package com.intellibucket.pipeql.view.client.intro.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.client.intro.abstracts.AbstractIntroChangeableCenterPanelClient;
import com.intellibucket.pipeql.view.components.intro.models.ProjectItemModel;
import com.intellibucket.pipeql.view.components.intro.panel.ProjectsCenterIntroPanel;
import com.intellibucket.pipeql.view.components.intro.screens.IntroductionScreen;

import java.util.List;

public class IntroChangeableCenterPanelClient extends AbstractIntroChangeableCenterPanelClient {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;

    @Override
    public void openProjects() {
        var models = List.of(
                new ProjectItemModel("Project 1", "/Users/abhishek/Desktop/Projects/Project1"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 2", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Project 3", "/Users/abhishek/Desktop/Projects/Project3")
        );
        var changeablePanel = new ProjectsCenterIntroPanel(models);
        var event = new StartEvent<>(new IntroductionScreen.ChangeablePanelListener.ChangeablePanelPayload(changeablePanel));
        var message = ProducingMessage.Builder
                .builder()
                .event(event)
                .topic("change-intro-screen-center-panel")
                .build();
        this.eventLinkTemplate.publish(message);
    }
}
