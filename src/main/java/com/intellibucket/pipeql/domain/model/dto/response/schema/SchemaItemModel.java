package com.intellibucket.pipeql.domain.model.dto.response.schema;

import com.intellibucket.pipeql.domain.model.dto.response.table.TableItemModel;

import java.util.List;
import java.util.UUID;

public record SchemaItemModel(UUID id, String name, List<TableItemModel> tables) {
}
