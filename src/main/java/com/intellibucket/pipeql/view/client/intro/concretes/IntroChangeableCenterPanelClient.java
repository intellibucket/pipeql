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
                new ProjectItemModel("PipeQl", "/Users/abhishek/Desktop/Projects/Project1"),
                new ProjectItemModel("Jobber", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("OnNetwork", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Gmail", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Micronaut", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("AVIS", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Office", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Word", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Excel", "/Users/abhishek/Desktop/Projects/Project2"),
                new ProjectItemModel("Axon", "/Users/abhishek/Desktop/Projects/Axon"),
                new ProjectItemModel("Alphabet", "/Users/abhishek/Desktop/Projects/Alphabet"),
                new ProjectItemModel("Exelidraw", "/Users/abhishek/Desktop/Projects/Exelidraw"),
                new ProjectItemModel("Kubernetes", "/Users/abhishek/Desktop/Projects/Kubernetes"),
                new ProjectItemModel("Docker", "/Users/abhishek/Desktop/Projects/Docker"),
                new ProjectItemModel("Apache Kafka", "/Users/abhishek/Desktop/Projects/apache-kafka")
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
