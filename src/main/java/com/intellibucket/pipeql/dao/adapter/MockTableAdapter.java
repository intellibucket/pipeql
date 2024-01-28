package com.intellibucket.pipeql.dao.adapter;

import com.intellibucket.pipeql.dao.MockDataProvider;
import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

import java.util.UUID;

public class MockTableAdapter implements AbstractTableAdapter {

    @Override
    public TableRoot fetchTableDetails(TableGetRequest request) {
        return MockDataProvider.MOKC_PROJECT.getSchemas().stream()
                .filter(schema -> schema.getId().equals(request.schemaId()))
                .findFirst()
                .orElseThrow()
                .getTables().stream()
                .filter(table -> table.getId().equals(request.tableId()))
                .findFirst()
                .orElseThrow();
    }

    public static void main(String[] args) {
        MockTableAdapter mockTableAdapter = new MockTableAdapter();
        var result = mockTableAdapter.fetchTableDetails(
                new TableGetRequest(UUID.fromString("cd0f82d9-c99a-45b4-89df-6f41eba2a094"),
                        UUID.fromString("5b65e93f-7cef-49f1-9b8c-71f146756d98"))
        );
        System.out.println(result);
    }
}
