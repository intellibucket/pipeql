package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.domain.model.dto.response.project.ProjectModel;

import java.util.List;

public class MockSchemaItemClient {

    public static ProjectModel getProject(){
        return ProjectModel.builder()
                .nameOfProject("Declaration")
                .createdBy("Vugar Mammadli")
                .description("This is a project for declaration")
                .version("1.0.0")
                .lastModifiedDate(java.time.LocalDateTime.now())
                .createdDate(java.time.LocalDateTime.now())
                .schemas(List.of())
                .build();
    }

}
