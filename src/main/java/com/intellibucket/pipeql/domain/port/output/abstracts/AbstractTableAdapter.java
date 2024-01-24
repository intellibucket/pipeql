package com.intellibucket.pipeql.domain.port.output.abstracts;

import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.TableRoot;

public interface AbstractTableAdapter {
    TableRoot fetchTableDetails(TableGetRequest request);
}
