package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;

import java.awt.*;
import java.util.List;

public abstract class ColumnListItemPanel extends AbstractGSimplePanel{
    private SimpleGLabel columnIconLabel;
    private SimpleGLabel columnNameLabel;
    private SimpleGLabel columnTypeLabel;
    private SimpleGLabel columnSizeLabel;
    private SimpleGLabel columnNullableLabel;
    private SimpleGLabel columnDefaultLabel;
    private SimpleGLabel columnForeignKeyIconLabel;

    {
        this.setLayout(new GridLayout(1, 7));
    }

    public ColumnListItemPanel(ColumnRoot columnRoot) {
        this.columnIconLabel =
                new SimpleGLabel(columnRoot.getIsPrimaryKey()? ImageToolKit.getIcon("goldKey") : ImageToolKit.getIcon("empty"));
        this.columnNameLabel = new SimpleGLabel(columnRoot.getName());
        this.columnTypeLabel = new SimpleGLabel(columnRoot.getDataType());
        this.columnSizeLabel = new SimpleGLabel(String.valueOf(columnRoot.getLength()));
        this.columnNullableLabel = new SimpleGLabel(columnRoot.getIsPrimaryKey()? ImageToolKit.getIcon("gutterCheckBoxSelected") : ImageToolKit.getIcon("gutterCheckBoxIndeterminate"));
        this.columnDefaultLabel = new SimpleGLabel(columnRoot.getDefaultValue());
        this.columnForeignKeyIconLabel = new SimpleGLabel(columnRoot.getIsPrimaryKey()? ImageToolKit.getIcon("blueKey") : ImageToolKit.getIcon("empty"));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.columnIconLabel, this.columnNameLabel, this.columnTypeLabel, this.columnSizeLabel, this.columnNullableLabel, this.columnDefaultLabel, this.columnForeignKeyIconLabel);
    }

    @Override
    public void setComponents() {
        this.add(this.columnIconLabel);
        this.add(this.columnNameLabel);
        this.add(this.columnTypeLabel);
        this.add(this.columnSizeLabel);
        this.add(this.columnNullableLabel);
        this.add(this.columnDefaultLabel);
        this.add(this.columnForeignKeyIconLabel);
    }
}
