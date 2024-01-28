package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.dao.adapter.factory.AdapterFactory;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

public class TableDetailService implements AbstractTableDetailService {
    private final AbstractTableAdapter tableAdapter = AdapterFactory.factoryTableAdapter();


    @Override
    public TableRoot findById(TableID tableId) {
        var optionalTable = tableAdapter.findById(tableId);
        if (optionalTable.isEmpty()) throw new RuntimeException("Table not found");
        else return optionalTable.get();
    }
}
