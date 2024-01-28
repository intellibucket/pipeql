package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.domain.model.valueo.TableID;

import java.util.UUID;

public interface AbstractMainCenterTablePanelClient {
    void openTable(TableID tableId);
}
