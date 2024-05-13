package com.intellibucket.pipeql.view.actions.main.concretes;

import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractRightSidePanelClient;
import com.intellibucket.pipeql.view.topics.RightMainPanelTopics;

public class RightSidePanelClient implements AbstractRightSidePanelClient {

    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;

    @Override
    public void openNotificationSideBar(Callback callback) {
        var message = ProducingMessage.Builder
                .builder()
                .callback(callback)
                .topic(RightMainPanelTopics.CLICKED_OPEN_NOTIFICATION_SIDE_BAR)
                .build();
        this.eventLinkTemplate.publish(message);
    }


}
