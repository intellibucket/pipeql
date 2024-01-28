package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.dao.adapter.factory.AdapterFactory;
import com.intellibucket.pipeql.domain.model.dto.response.SchemaItemModel;
import com.intellibucket.pipeql.domain.model.dto.response.TableItemModel;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractSchemaDetailService;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractSchemaAdapter;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

import java.util.List;

public class SchemaDetailService implements AbstractSchemaDetailService {
    private final AbstractSchemaAdapter tableAdapter = AdapterFactory.factorySchemaAdapter();

    @Override
    public List<SchemaItemModel> findAllSimpleItem() {
        return  tableAdapter.findAll()
                .stream()
                .map(schema -> {
                    var tables = schema.getTables()
                            .stream()
                            .map(table -> new TableItemModel(table.getId(), schema.getId(), table.getName(), table.getIsValid()))
                            .toList();
                    return new SchemaItemModel(schema.getId(), schema.getName(), tables);
                })
                .toList();
    }
}
