package com.intellibucket.pipeql.domain.model.json.draw.element;

import com.intellibucket.pipeql.domain.model.json.type.draw.Binding;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Getter
@SuperBuilder
public class ArrowElement extends SuperElement{
    private final BigDecimal strokeColor;
    private final BigDecimal strokeWidth;
    private final Binding startBinding;
    private final Binding endBinding;
}
