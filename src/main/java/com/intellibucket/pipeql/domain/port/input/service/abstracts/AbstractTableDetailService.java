package com.intellibucket.pipeql.domain.port.input.service.abstracts;

import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;

public interface AbstractTableDetailService {

    TableRoot findById(TableID tableId);
}
