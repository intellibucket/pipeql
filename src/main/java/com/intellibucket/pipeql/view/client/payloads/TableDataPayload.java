package com.intellibucket.pipeql.view.client.payloads;

import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;

public class TableDataPayload implements Payload {
    private final TableRoot table;

    public TableDataPayload(TableRoot table) {
        this.table = table;
    }

    public TableRoot getTable() {
        return table;
    }
}
