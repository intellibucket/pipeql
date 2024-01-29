package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.table.ColumnGTable;

import java.awt.*;
import java.util.List;

public abstract class ItemWithBarPanel extends AbstractGSimplePanel{
    private AbstractGSimplePanel header;
    private AbstractGSimplePanel center;

    public ItemWithBarPanel() {
        this.header = new ItemHeaderPanel();
        this.center = new ItemTextFieldPanel();
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

    class ItemTextFieldPanel extends AbstractGSimplePanel {

        {
            this.setLayout(new BorderLayout());
        }
        public ItemTextFieldPanel() {
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(

            );
        }

        @Override
        public void setComponents() {
        }
    }
}


