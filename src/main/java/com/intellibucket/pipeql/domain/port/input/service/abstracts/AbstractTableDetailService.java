package com.intellibucket.pipeql.domain.port.input.service.abstracts;

import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.TableRoot;

public interface AbstractTableDetailService {
    TableRoot fetchTableDetails(TableGetRequest request);
}
