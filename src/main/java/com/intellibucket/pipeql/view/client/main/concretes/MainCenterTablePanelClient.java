package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.input.service.factory.DetailServiceFactory;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractMainCenterTablePanelClient;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainCenterTablePanelClient implements AbstractMainCenterTablePanelClient {
    private final AbstractTableDetailService tableDetailService = DetailServiceFactory.factoryTableDetailService();
    @Override
    public void openTable(TableID tableId) {
        log.info("openTable: {}", tableId);
        var table = tableDetailService.findById(tableId);
        log.info("openTable: {}", table);
    }
}
