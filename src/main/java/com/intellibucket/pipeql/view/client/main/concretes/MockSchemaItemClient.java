package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.domain.model.dto.response.ProjectModel;
import com.intellibucket.pipeql.domain.model.dto.response.SchemaItemModel;
import com.intellibucket.pipeql.domain.model.dto.response.TableItemModel;

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
                .schemas(getSchemas())
                .build();
    }

    public static List<SchemaItemModel> getSchemas(){
        var publicSchema = new SchemaItemModel(
                java.util.UUID.randomUUID(),
                "public",
                List.of(
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "users",
                                true),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "roles",
                                false),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "permissions",
                                true),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "user_roles",
                                true),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "role_permissions",
                                true)
                ));
         var testSchema = new SchemaItemModel(
                java.util.UUID.randomUUID(),
                "replica",
                List.of(
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "replica",
                                "countries",
                                false),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "replica",
                                "cities",
                                true),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "replica",
                                "locations",
                                false),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "replica",
                                "addresses",
                                true),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "replica",
                                "coordinates",
                                false)
                ));
        return List.of(publicSchema, testSchema);

    }
}
