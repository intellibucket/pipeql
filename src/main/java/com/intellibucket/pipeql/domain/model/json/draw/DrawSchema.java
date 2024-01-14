package com.intellibucket.pipeql.domain.model.json.draw;

import com.intellibucket.pipeql.domain.model.json.Schema;
import lombok.Builder;

@Schema
@Builder
public class DrawSchema {
    private final AppStateSchema appState;
}
