package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.dao.MockDataProvider;
import com.intellibucket.pipeql.domain.model.root.SchemaRoot;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.SchemaID;
import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

import java.util.List;
import java.util.Optional;

public class MockTableAdapter implements AbstractTableAdapter {


    @Override
    public Optional<TableRoot> findById(TableID tableID) {
        var optional =  MockDataProvider.MOKC_PROJECT.getSchemas()
                .stream()
                .filter(schemaRoot -> schemaRoot.isSameId(tableID.getSchemaId()))
                .map(schemaRoot -> schemaRoot.getTables()
                        .stream()
                        .filter(tableRoot -> tableRoot.isSameId(tableID.getTableId()))
                        .findFirst())
                .findFirst();
        return optional.orElseGet(Optional::empty);
    }

    @Override
    public List<TableRoot> findAllBySchemaId(SchemaID schemaId) {
        return MockDataProvider.MOKC_PROJECT.getSchemas()
                .stream()
                .filter(schemaRoot -> schemaRoot.isSameId(schemaId.getSchemaId()))
                .map(SchemaRoot::getTables)
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<TableRoot> findAll() {
        return MockDataProvider.MOKC_PROJECT.getSchemas()
                .stream()
                .map(SchemaRoot::getTables)
                .flatMap(List::stream)
                .toList();
    }

    @Override
    public List<TableRoot> findAllById(List<TableID> tableIDS) {
        return null;
    }

    @Override
    public TableRoot save(TableRoot entity) {
        return null;
    }

    @Override
    public void deleteById(TableID tableID) {

    }

    @Override
    public void deleteAll() {

    }

}
