package com.intellibucket.pipeql.domain.model.json.type.draw;

import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
public class BoundElement {
    private final UUID id;
    private final ElementType type;
}
