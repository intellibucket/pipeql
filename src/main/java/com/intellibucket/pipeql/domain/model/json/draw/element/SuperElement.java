package com.intellibucket.pipeql.domain.model.json.draw.element;

import com.intellibucket.pipeql.domain.model.json.draw.type.FillStyle;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
public class SuperElement {
    private final UUID id;
    private final BigInteger createdStamp;
    private final BigInteger modificationStamp;
    private final BigInteger version;
    private final UUID frameId;
    private final FillStyle fillStyle;
    private final String type;
    private final BigDecimal x;
    private final BigDecimal y;
    private final BigDecimal width;
    private final BigDecimal height;
    private final String backgroundColor;
    private final String borderColor;
    private final BigDecimal opacity;
    private final BigInteger seed;
    private final List<SuperElement> bounds;
    private final String link;
    private final Boolean isLocked;

}
