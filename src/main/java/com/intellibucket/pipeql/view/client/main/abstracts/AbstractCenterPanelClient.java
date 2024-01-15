package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;

public interface AbstractCenterPanelClient {
    void closeAllSchemas();
    void closeAllSchemas(Callback callback);
}
