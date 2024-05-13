package com.intellibucket.pipeql.view.actions.main.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.view.actions.main.concretes.RightSidePanelClient;

public interface AbstractRightSidePanelClient {
    AbstractRightSidePanelClient INSTANCE = new RightSidePanelClient();

    void openNotificationSideBar(Callback callback);
}
