package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.dao.adapter.factory.AdapterFactory;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractColumnDetailService;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractColumnAdapter;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

public class ColumnDetailService implements AbstractColumnDetailService {
    private final AbstractColumnAdapter tableAdapter = AdapterFactory.factoryColumnAdapter();


}
