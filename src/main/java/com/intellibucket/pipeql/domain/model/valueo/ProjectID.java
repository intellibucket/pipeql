package com.intellibucket.pipeql.domain.model.valueo;

import java.util.UUID;

public class ProjectID {
    private final UUID projectID;

    public ProjectID(UUID projectID) {
        this.projectID = projectID;
    }

    public UUID getProjectID() {
        return projectID;
    }

    public static ProjectID of(UUID projectID) {
        return new ProjectID(projectID);
    }
}
