package com.intellibucket.pipeql.domain.port.input.service.factory;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.*;
import com.intellibucket.pipeql.domain.port.input.service.concretes.*;

public class DetailServiceFactory {
    public static AbstractColumnDetailService factoryColumnDetailService() {
        return new ColumnDetailService();
    }

    public static AbstractTableDetailService factoryTableDetailService() {
        return new TableDetailService();
    }

    public static AbstractSchemaDetailService factorySchemaDetailService() {
        return new SchemaDetailService();
    }
}
