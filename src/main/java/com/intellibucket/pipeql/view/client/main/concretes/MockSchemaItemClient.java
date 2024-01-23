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
