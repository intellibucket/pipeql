package com.intellibucket.pipeql.view.client.intro.concretes;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.view.client.intro.abstracts.AbstractIntroChangeableCenterPanelClient;
import com.intellibucket.pipeql.view.components.intro.screens.IntroductionScreen;

public class IntroChangeableCenterPanelClient extends AbstractIntroChangeableCenterPanelClient {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;

    @Override
    public void changePanel(ChangeablePanel changeablePanel) {
        var event = new StartEvent<>(new IntroductionScreen.ChangeablePanelListener.ChangeablePanelPayload(changeablePanel));
        var message = ProducingMessage.Builder
                .builder()
                .event(event)
                .topic("change-intro-screen-center-panel")
                .build();
        this.eventLinkTemplate.publish(message);
    }
}
