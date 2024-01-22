package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.view.components.main.model.SchemaItemModel;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;

import java.util.List;

public class MockSchemaItemClient {
    public static List<SchemaItemModel> getSchemas(){
        var publicSchema = new SchemaItemModel(
                java.util.UUID.randomUUID(),
                "public",
                List.of(
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "users"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "roles"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "permissions"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "user_roles"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "public",
                                "role_permissions")
                ));
         var testSchema = new SchemaItemModel(
                java.util.UUID.randomUUID(),
                "test",
                List.of(
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "test",
                                "users_2"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "test",
                                "roles_2"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "test",
                                "permissions_2"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "test",
                                "user_roles_2"),
                        new TableItemModel(
                                java.util.UUID.randomUUID(),
                                "test",
                                "role_permissions_2")
                ));
        return List.of(publicSchema, testSchema);

    }
}
