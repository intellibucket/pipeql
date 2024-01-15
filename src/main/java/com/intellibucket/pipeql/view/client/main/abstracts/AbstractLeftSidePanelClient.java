package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;

public interface AbstractLeftSidePanelClient {
    void openSettingsScreen(Callback callback);
    void openDatabasesScreen(Callback callback);
    void openQueryScreen(Callback callback);
    void openDataSetScreen(Callback callback);
    void openDataTypesScreen(Callback callback);
}
