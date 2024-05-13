package com.intellibucket.pipeql.view.actions.main.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.view.actions.main.concretes.LeftSidePanelClient;

public interface AbstractLeftSidePanelClient {
    AbstractLeftSidePanelClient INSTANCE = new LeftSidePanelClient();

    void openProjectsLeftBarScreen(Callback callback);
    void openSettingsScreen(Callback callback);
    void openDatabasesScreen(Callback callback);
    void openQueryScreen(Callback callback);
    void openDataSetScreen(Callback callback);
    void openDataTypesScreen(Callback callback);
}
