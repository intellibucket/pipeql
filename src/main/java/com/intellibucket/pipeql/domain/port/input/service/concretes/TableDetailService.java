package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.dao.adapter.MockTableAdapter;
import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

public class TableDetailService implements AbstractTableDetailService {

    private final AbstractTableAdapter tableAdapter = new MockTableAdapter();


}
