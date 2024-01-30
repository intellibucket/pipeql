package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GColumnListItemHeaderPanel extends AbstractGSimplePanel{

    private SimpleGLabel columnNameLabel = new SimpleGLabel("Column Name", JLabel.CENTER);
    private SimpleGLabel isAutoIncrementLabel =  new SimpleGLabel("Auto Increment", JLabel.CENTER);
    private SimpleGLabel columnTypeLabel = new SimpleGLabel("Column Type", JLabel.LEFT);
    private SimpleGLabel columnSizeLabel = new SimpleGLabel("Column Size", JLabel.LEFT);
    private SimpleGLabel columnNullableLabel = new SimpleGLabel("Nullable", JLabel.CENTER);
    private SimpleGLabel columnDefaultLabel = new SimpleGLabel("Default Value", JLabel.LEFT);
    private SimpleGLabel columnForeignKeyIconLabel = new SimpleGLabel("Foreign Key", JLabel.LEFT);
    private SimpleGLabel isUniqueLabel = new SimpleGLabel("Unique", JLabel.CENTER);
    private SimpleGLabel isIndexedLabel = new SimpleGLabel("Indexed", JLabel.CENTER);
    private SimpleGLabel isReadOnlyLabel = new SimpleGLabel("Read Only", JLabel.CENTER);

    {
        this.setLayout(new GridLayout(1, 4));
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.columnNameLabel,
                this.isAutoIncrementLabel,
                this.columnTypeLabel,
                this.columnSizeLabel,
                this.columnNullableLabel,
                this.columnDefaultLabel,
                this.columnForeignKeyIconLabel,
                this.isUniqueLabel,
                this.isIndexedLabel,
                this.isReadOnlyLabel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.columnNameLabel);
        this.add(this.isAutoIncrementLabel);
        this.add(this.columnTypeLabel);
        this.add(this.columnSizeLabel);
        this.add(this.columnNullableLabel);
        this.add(this.columnDefaultLabel);
        this.add(this.columnForeignKeyIconLabel);
        this.add(this.isUniqueLabel);
        this.add(this.isIndexedLabel);
        this.add(this.isReadOnlyLabel);
    }
}
