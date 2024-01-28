package com.intellibucket.pipeql.dao;

import com.fasterxml.jackson.core.StreamReadFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.intellibucket.pipeql.domain.model.root.ProjectRoot;

import java.io.File;
import java.io.IOException;

public class MockDataProvider {
    static ProjectRoot MOKC_PROJECT = null;

    static {
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(StreamReadFeature.INCLUDE_SOURCE_IN_LOCATION.mappedFeature());
        try {
            MOKC_PROJECT = mapper.readValue(new File("src/main/resources/mock/project.json"), ProjectRoot.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
