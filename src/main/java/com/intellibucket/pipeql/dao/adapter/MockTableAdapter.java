package com.intellibucket.pipeql.dao.adapter;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.pipeql.domain.model.dto.request.TableGetRequest;
import com.intellibucket.pipeql.domain.model.root.ProjectRoot;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class MockTableAdapter implements AbstractTableAdapter {
    @Override
    public TableRoot fetchTableDetails(TableGetRequest request) {
        ProjectRoot schemaRoot = null;
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature());
        try {
            schemaRoot = mapper.readValue(new File("src/main/resources/mock/project.json"), ProjectRoot.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
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
