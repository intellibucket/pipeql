package com.intellibucket.pipeql.lib.table;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.border.BorderUtils;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class ColumnGTable extends AbstractGTable{

    private static Object[] columnNames = {"Column Name", "Data Type", "Length", "Is Primary", "Nullable", "Default Value", "Comments"};

    private static final Object[][] EMPTY_DATA = {
            {"", "", "", "", "", "", ""}
    };

    {
        this.setBorder(BorderUtils.EMPTY_BORDER_5_5_5_5);
    }

    public ColumnGTable() {
        super(new DefaultTableModel(EMPTY_DATA, columnNames));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
