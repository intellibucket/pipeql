package com.intellibucket.pipeql.domain.model.json.draw.element;

import com.intellibucket.pipeql.domain.model.json.draw.type.Binding;
import com.intellibucket.pipeql.domain.model.json.draw.type.FillStyle;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
public class ArrowElement extends SuperElement{
    private final BigDecimal strokeColor;
    private final BigDecimal strokeWidth;
    private final Binding startBinding;
    private final Binding endBinding;
}
