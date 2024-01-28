package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.domain.model.valueo.ColumnID;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractColumnAdapter;

import java.util.List;

public class MockColumnAdapter implements AbstractColumnAdapter {

    @Override
    public ColumnRoot findById(ColumnID columnID) {
        return null;
    }

    @Override
    public List<ColumnRoot> findAll() {
        return null;
    }

    @Override
    public List<ColumnRoot> findAllById(List<ColumnID> columnIDS) {
        return null;
    }

    @Override
    public ColumnRoot save(ColumnRoot entity) {
        return null;
    }

    @Override
    public void deleteById(ColumnID columnID) {

    }

    @Override
    public void deleteAll() {

    }
}
