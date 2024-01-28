package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.view.client.main.abstracts.AbstractMainCenterTablePanelClient;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class MainCenterTablePanelClient implements AbstractMainCenterTablePanelClient {
    @Override
    public void openTable(UUID tableId) {
        var schemas = MockSchemaItemClient.getSchemas();
        log.info("Opening table with id: {}", tableId);

    }
}
