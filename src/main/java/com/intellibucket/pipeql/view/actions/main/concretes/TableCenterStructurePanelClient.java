package com.intellibucket.pipeql.view.actions.main.concretes;

import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.input.service.factory.DetailServiceFactory;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractTableCenterStructurePanelClient;

public class TableCenterStructurePanelClient implements AbstractTableCenterStructurePanelClient {
    private final AbstractTableDetailService tableDetailService = DetailServiceFactory.factoryTableDetailService();

    @Override
    public TableRoot fetchTableRoot(TableID tableID) {
        return tableDetailService.findById(tableID);
    }
}
