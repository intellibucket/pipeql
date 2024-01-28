package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.dao.MockDataProvider;
import com.intellibucket.pipeql.domain.model.root.SchemaRoot;
import com.intellibucket.pipeql.domain.model.valueo.SchemaID;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractSchemaAdapter;

import java.util.List;
import java.util.Optional;

public class MockSchemaAdapter implements AbstractSchemaAdapter {
    @Override
    public Optional<SchemaRoot> findById(SchemaID schemaID)  {
        return MockDataProvider.MOKC_PROJECT.getSchemas().stream()
                .filter(schema -> schema.getId().equals(schemaID.getSchemaId()))
                .findFirst();
    }
    @Override
    public List<SchemaRoot> findAll() {
        return MockDataProvider.MOKC_PROJECT.getSchemas();
    }

    @Override
    public List<SchemaRoot> findAllById(List<SchemaID> schemaIDS) {
        return MockDataProvider.MOKC_PROJECT.getSchemas()
                .stream()
                .filter(schema -> schemaIDS.stream()
                        .anyMatch(schemaID -> schemaID.getSchemaId().equals(schema.getId())))
                .toList();
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
