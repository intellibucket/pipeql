package com.intellibucket.pipeql.domain.model.dto.request;


import java.util.UUID;

public record TableGetRequest(UUID schemaId, UUID tableId) {}
