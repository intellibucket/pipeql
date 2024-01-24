package com.intellibucket.pipeql.domain.model.dto.request;


import java.util.UUID;

public record ColumnGetRequest(UUID schemaId, UUID tableId, UUID columnId) { }
