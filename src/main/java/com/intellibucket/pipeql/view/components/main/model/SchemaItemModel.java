package com.intellibucket.pipeql.view.components.main.model;

import java.util.List;
import java.util.UUID;

public record SchemaItemModel(UUID id, String name, List<TableItemModel> tables) {
}
