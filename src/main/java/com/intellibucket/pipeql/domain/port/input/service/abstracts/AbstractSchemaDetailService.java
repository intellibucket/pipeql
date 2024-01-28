package com.intellibucket.pipeql.domain.port.input.service.abstracts;

import com.intellibucket.pipeql.domain.model.dto.response.SchemaItemModel;

import java.util.List;

public interface AbstractSchemaDetailService {
    List<SchemaItemModel> findAllSimpleItem();


}
