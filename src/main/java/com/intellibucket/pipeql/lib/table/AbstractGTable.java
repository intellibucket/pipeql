package com.intellibucket.pipeql.lib.table;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import java.util.Vector;

public abstract class AbstractGTable extends JTable implements ComponentInitializer {

    public AbstractGTable() {
    }

    public AbstractGTable(TableModel dm) {
        super(dm);
    }

    public AbstractGTable(TableModel dm, TableColumnModel cm) {
        super(dm, cm);
    }

    public AbstractGTable(TableModel dm, TableColumnModel cm, ListSelectionModel sm) {
        super(dm, cm, sm);
    }

    public AbstractGTable(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public AbstractGTable(Vector<? extends Vector> rowData, Vector<?> columnNames) {
        super(rowData, columnNames);
    }

    public AbstractGTable(Object[][] rowData, Object[] columnNames) {
        super(rowData, columnNames);
    }
}
