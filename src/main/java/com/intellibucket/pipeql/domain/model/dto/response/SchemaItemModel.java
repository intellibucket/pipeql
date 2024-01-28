package com.intellibucket.pipeql.domain.model.dto.response;

import java.util.List;
import java.util.UUID;

public record SchemaItemModel(UUID id, String name, List<TableItemModel> tables) {
}
