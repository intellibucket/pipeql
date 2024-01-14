package com.intellibucket.pipeql.domain.model.json.type.draw;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class Binding {
    private final UUID elementId;
    private final BigDecimal focus;
    private final BigDecimal gap;
}
