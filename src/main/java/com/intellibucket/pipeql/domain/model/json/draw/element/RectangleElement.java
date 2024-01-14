package com.intellibucket.pipeql.domain.model.json.draw.element;

import com.intellibucket.pipeql.domain.model.json.draw.type.Roundness;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
@Getter
public class RectangleElement extends SuperElement{
    private final Roundness roundness;
    private final BigDecimal angle;
    private final BigInteger roughness;
}
