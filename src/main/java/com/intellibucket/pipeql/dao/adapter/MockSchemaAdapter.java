package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.domain.model.root.SchemaRoot;
import com.intellibucket.pipeql.domain.model.valueo.SchemaID;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractSchemaAdapter;

import java.util.List;

public class MockSchemaAdapter implements AbstractSchemaAdapter {
    @Override
    public SchemaRoot findById(SchemaID schemaID) {
        return null;
    }

    @Override
    public List<SchemaRoot> findAll() {
        return null;
    }

    @Override
    public List<SchemaRoot> findAllById(List<SchemaID> schemaIDS) {
        return null;
    }

    @Override
    public SchemaRoot save(SchemaRoot entity) {
        return null;
    }

    @Override
    public void deleteById(SchemaID schemaID) {

    }

    @Override
    public void deleteAll() {

    }
}
