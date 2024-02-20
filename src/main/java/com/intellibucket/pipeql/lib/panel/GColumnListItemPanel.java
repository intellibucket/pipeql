package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Stream;

public class GColumnListItemPanel extends AbstractGSimplePanel{
    private ColumnRoot columnRoot;

    private SimpleGLabel columnNameLabel;
    private SimpleGLabel isAutoIncrementLabel;
    private SimpleGLabel columnTypeLabel;
    private SimpleGLabel columnSizeLabel;
    private SimpleGLabel columnNullableLabel;
    private SimpleGLabel columnDefaultLabel;
    private SimpleGLabel columnForeignKeyIconLabel;
    private SimpleGLabel isUniqueLabel;
    private SimpleGLabel isIndexedLabel;
    private SimpleGLabel isReadOnlyLabel;

    {
        this.setLayout(new GridLayout(1, 4));
    }

    public GColumnListItemPanel(ColumnRoot columnRoot) {
        this.columnRoot = columnRoot;
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
        this.columnNameLabel = new SimpleGLabel(
                columnRoot.getName(),
                columnRoot.getIsPrimaryKey() ?
                        ImageToolKit.getIcon("goldKey")
                        : ImageToolKit.getIcon("empty"),
                JLabel.LEFT);
        this.isAutoIncrementLabel = new SimpleGLabel(
                columnRoot.getIsAutoIncrement() ?
                        ImageToolKit.getIcon("gutterCheckBoxSelected")
                        : ImageToolKit.getIcon("gutterCheckBoxIndeterminate")
        );
        this.columnTypeLabel = new SimpleGLabel(columnRoot.getDataType());
        this.columnSizeLabel = new SimpleGLabel(String.valueOf(columnRoot.getLength()));
        this.columnNullableLabel = new SimpleGLabel(
                columnRoot.getIsPrimaryKey() ?
                        ImageToolKit.getIcon("gutterCheckBoxSelected") :
                        ImageToolKit.getIcon("gutterCheckBoxIndeterminate")
        );
        this.columnDefaultLabel = new SimpleGLabel(columnRoot.getDefaultValueOrElse());
        this.columnForeignKeyIconLabel = new SimpleGLabel(
                "not presented",
                columnRoot.getIsForeignKey() ?
                        ImageToolKit.getIcon("blueKey") :
                        ImageToolKit.getIcon("empty"),
                JLabel.LEFT
        );
        this.isUniqueLabel = new SimpleGLabel(
                columnRoot.getIsUnique() ?
                        ImageToolKit.getIcon("gutterCheckBoxSelected") :
                        ImageToolKit.getIcon("gutterCheckBoxIndeterminate")
        );
        this.isIndexedLabel = new SimpleGLabel(
                columnRoot.getIsIndexed() ?
                        ImageToolKit.getIcon("gutterCheckBoxSelected") :
                        ImageToolKit.getIcon("gutterCheckBoxIndeterminate")
        );
        this.isReadOnlyLabel = new SimpleGLabel(
                columnRoot.getIsReadOnly() ?
                        ImageToolKit.getIcon("gutterCheckBoxSelected") :
                        ImageToolKit.getIcon("gutterCheckBoxIndeterminate")
        );

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
