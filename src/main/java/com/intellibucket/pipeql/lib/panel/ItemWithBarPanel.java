package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.list.GColumnList;
import com.intellibucket.pipeql.view.util.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class ItemWithBarPanel extends AbstractGSimplePanel{
    private AbstractGSimplePanel header;
    private AbstractGSimplePanel center;

    public ItemWithBarPanel(List<AbstractGSimplePanel> columns) {
        this.header = new ItemHeaderPanel();
        this.center = new ItemColumnsPanel(columns);
    }

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.header,
                this.center
        );
    }

    @Override
    public void setComponents() {
        this.add(this.header, BorderLayout.NORTH);
        this.add(this.center, BorderLayout.CENTER);
    }

    class ItemHeaderPanel extends AbstractGSimplePanel {

        private final AbstractGButton addButton = new SimpleIconGButton("addBlankLine");
        private final AbstractGButton deleteButton = new SimpleIconGButton("remove");
        private final AbstractGButton duplicateButton = new SimpleIconGButton("duplicate");

        {
            this.setLayout(new FlowLayout(FlowLayout.LEFT));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.addButton,
                    this.deleteButton,
                    this.duplicateButton
            );
        }

        @Override
        public void setComponents() {
            this.add(this.addButton);
            this.add(this.deleteButton);
            this.add(this.duplicateButton);
        }
    }

    class ItemColumnsPanel extends AbstractGSimplePanel {
        private CustomGColumnList columnList;
        private GColumnListItemHeaderPanel headerPanel;

        {
            this.setLayout(new BorderLayout());
            this.setBorder(BorderFactory.createLineBorder(ColorUtils.COLORFUL_BUTTON_BACKGROUND, 1));
        }
        public ItemColumnsPanel(List<AbstractGSimplePanel> columnListItemPanels) {
            this.columnList = new CustomGColumnList(columnListItemPanels);
            this.headerPanel = new GColumnListItemHeaderPanel();
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.columnList,
                    this.headerPanel
            );
        }

        @Override
        public void setComponents() {
            this.add(this.headerPanel, BorderLayout.NORTH);
            this.add(this.columnList, BorderLayout.CENTER);
        }

        class CustomGColumnList extends GColumnList{

            protected CustomGColumnList(List<AbstractGSimplePanel> items) {
                super(items);
            }

        }
    }
}


