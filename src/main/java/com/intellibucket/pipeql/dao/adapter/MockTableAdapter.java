package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

import java.util.List;

public class MockTableAdapter implements AbstractTableAdapter {


    @Override
    public TableRoot findById(TableID tableID) {
        return null;
    }

    @Override
    public List<TableRoot> findAll() {
        return null;
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
