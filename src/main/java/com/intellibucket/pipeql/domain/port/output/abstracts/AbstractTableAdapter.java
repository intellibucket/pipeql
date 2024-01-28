package com.intellibucket.pipeql.domain.port.output.abstracts;

import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.ColumnID;
import com.intellibucket.pipeql.domain.model.valueo.TableID;

public interface AbstractTableAdapter extends AbstractAdapter<TableID, TableRoot>{
}
