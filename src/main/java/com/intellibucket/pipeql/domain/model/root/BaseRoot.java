package com.intellibucket.pipeql.domain.model.root;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseRoot {
    private UUID id;
    private Boolean isActive;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
    private Short version;
    private Boolean isValid;

    public abstract <T> Boolean isSameId(T id);
}
