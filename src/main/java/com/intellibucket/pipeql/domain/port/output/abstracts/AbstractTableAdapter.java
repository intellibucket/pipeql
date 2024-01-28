package com.intellibucket.pipeql.domain.port.output.abstracts;

import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.SchemaID;
import com.intellibucket.pipeql.domain.model.valueo.TableID;

import java.util.List;

public interface AbstractTableAdapter extends AbstractAdapter<TableID, TableRoot>{
    List<TableRoot> findAllBySchemaId(SchemaID schemaId);
}
