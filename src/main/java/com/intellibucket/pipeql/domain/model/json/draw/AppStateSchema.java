package com.intellibucket.pipeql.domain.model.json.draw;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;

import java.math.BigDecimal;

@Schema
@Builder
public class AppStateSchema {
    private final BigDecimal gridSize;
    private final String viewBackgroundColor;
}
