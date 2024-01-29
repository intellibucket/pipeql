package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure.center;

import com.intellibucket.pipeql.domain.model.dto.response.table.TableItemModel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.GItemTextFieldPanel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.util.ColorUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public
class TableCenterStructurePanel extends AbstractGSimplePanel {
    {
        this.setLayout(new BorderLayout());
    }

    private final TableItemModel tableItemModel;
    private final HeaderOfTableCenterStructurePanel headerOfTableCenterStructurePanel;
    private final CenterOfTableCenterStructurePanel centerOfTableCenterStructurePanel;

    public TableCenterStructurePanel(TableItemModel tableItemModel) {
        this.tableItemModel = tableItemModel;
        this.headerOfTableCenterStructurePanel = new HeaderOfTableCenterStructurePanel();
        this.centerOfTableCenterStructurePanel = new CenterOfTableCenterStructurePanel();
    }


    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return java.util.List.of(
                this.headerOfTableCenterStructurePanel,
                this.centerOfTableCenterStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.headerOfTableCenterStructurePanel, BorderLayout.NORTH);
        this.add(this.centerOfTableCenterStructurePanel, BorderLayout.CENTER);
    }

}

class HeaderOfTableCenterStructurePanel extends TransparentGPanel {

    private final GItemTextFieldPanel tableNameTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Table Name:");
    private final GItemTextFieldPanel commentsTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Comments:");

    {
        this.setLayout(new GridLayout(1, 2));
    }

    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return java.util.List.of(
                this.tableNameTFPanel,
                this.commentsTFPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.tableNameTFPanel);
        this.add(this.commentsTFPanel);
    }

    class ItemTextFieldPanel extends GItemTextFieldPanel {

        public ItemTextFieldPanel(String value) {
            super(value);
        }
    }

}

class CenterOfTableCenterStructurePanel extends TransparentGPanel {

    private JSplitPane splitPane;

    private InnerResizeablePanel topPanel;
    private InnerResizeablePanel bottomPanel;

    public CenterOfTableCenterStructurePanel() {
        this.topPanel = new TopOfCenterOfTableCenterStructurePanel();
        this.bottomPanel = new BottomOfCenterOfTableCenterStructurePanel();
        this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.topPanel, this.bottomPanel);
        this.splitPane.setDividerLocation(0.5);
    }

    {
        this.setLayout(new BorderLayout());
    }
    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.topPanel,
                this.bottomPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.splitPane, BorderLayout.CENTER);
    }
}


class TopOfCenterOfTableCenterStructurePanel extends InnerResizeablePanel{

    private final TabbedPaneOfTopOfCenterOfTableCenterStructurePanel tabbedPaneOfTopOfCenterOfTableCenterStructurePanel;

    public TopOfCenterOfTableCenterStructurePanel() {
        this.tabbedPaneOfTopOfCenterOfTableCenterStructurePanel = new TabbedPaneOfTopOfCenterOfTableCenterStructurePanel();
    }

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.tabbedPaneOfTopOfCenterOfTableCenterStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.tabbedPaneOfTopOfCenterOfTableCenterStructurePanel, BorderLayout.CENTER);
    }
}

class TabbedPaneOfTopOfCenterOfTableCenterStructurePanel extends AbstractMaximizedGTabbedPane {
    private AbstractGSimplePanel columnsPanel;
    private AbstractGSimplePanel indexesPanel;
    private AbstractGSimplePanel triggersPanel;
    private AbstractGSimplePanel foreignKeysPanel;

    public TabbedPaneOfTopOfCenterOfTableCenterStructurePanel() {
        this.columnsPanel = new ColumnsPanel();
        this.indexesPanel = new IndexesPanel();
        this.triggersPanel = new TriggersPanel();
        this.foreignKeysPanel = new ForeignKeysPanel();
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.columnsPanel,
                this.indexesPanel,
                this.triggersPanel,
                this.foreignKeysPanel
        );
    }

    @Override
    public void setComponents() {
        this.add("Columns", this.columnsPanel);
        this.add("Indexes", this.indexesPanel);
        this.add("Triggers", this.triggersPanel);
        this.add("Foreign Keys", this.foreignKeysPanel);
    }

    class ColumnsPanel extends AbstractGSimplePanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }

    class IndexesPanel extends AbstractGSimplePanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }

    class TriggersPanel extends AbstractGSimplePanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }

    class ForeignKeysPanel extends AbstractGSimplePanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }


}


class BottomOfCenterOfTableCenterStructurePanel extends InnerResizeablePanel{

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return null;
    }

    @Override
    public void setComponents() {

    }
}