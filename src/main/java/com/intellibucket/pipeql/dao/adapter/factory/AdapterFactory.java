package com.intellibucket.pipeql.dao.adapter.factory;

import com.intellibucket.pipeql.dao.adapter.MockColumnAdapter;
import com.intellibucket.pipeql.dao.adapter.MockSchemaAdapter;
import com.intellibucket.pipeql.dao.adapter.MockTableAdapter;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractColumnAdapter;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractSchemaAdapter;
import com.intellibucket.pipeql.domain.port.output.abstracts.AbstractTableAdapter;

public class AdapterFactory {

    public static AbstractColumnAdapter factoryColumnAdapter() {
        return new MockColumnAdapter();
    }

    public static AbstractSchemaAdapter factorySchemaAdapter() {
        return new MockSchemaAdapter();
    }

    public static AbstractTableAdapter factoryTableAdapter() {
        return new MockTableAdapter();
    }


}
