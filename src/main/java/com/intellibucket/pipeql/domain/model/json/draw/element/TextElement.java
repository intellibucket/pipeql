package com.intellibucket.pipeql.domain.model.json.draw.element;

import lombok.Builder;

import java.math.BigDecimal;
import java.math.BigInteger;

@Builder
public class TextElement extends SuperElement{
    private final String text;
    private final String fontFamily;
    private final String fontColor;
    private final String fontSize;
    private final String fontStyle;
    private final String fontWeight;
    private final String textAlign;
    private final String verticalAlign;
    private final BigDecimal lineHeight;
    private final BigInteger letterSpacing;
    private final BigInteger baselineShift;
}
