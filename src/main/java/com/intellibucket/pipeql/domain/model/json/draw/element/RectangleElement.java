package com.intellibucket.pipeql.domain.model.json.draw.element;

import com.intellibucket.pipeql.domain.model.json.type.draw.Roundness;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;

@Getter
@SuperBuilder
public class RectangleElement extends SuperElement{
    private final Roundness roundness;
    private final BigDecimal angle;
    private final BigInteger roughness;
}
