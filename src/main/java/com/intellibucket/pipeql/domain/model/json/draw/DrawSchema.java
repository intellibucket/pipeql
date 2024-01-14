package com.intellibucket.pipeql.domain.model.json.draw;

import com.intellibucket.pipeql.domain.model.json.type.Schema;
import com.intellibucket.pipeql.domain.model.json.draw.element.SuperElement;
import lombok.Builder;

import java.util.List;

@Schema
@Builder
public class DrawSchema {
    private final AppStateSchema appState;
    private final List<SuperElement> elements;
}
