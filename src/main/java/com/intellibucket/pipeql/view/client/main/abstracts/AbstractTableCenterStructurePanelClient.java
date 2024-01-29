package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;

public interface AbstractTableCenterStructurePanelClient {
    TableRoot fetchTableRoot(TableID tableID);
}
