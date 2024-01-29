package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure.center;

import com.intellibucket.pipeql.domain.model.dto.response.table.TableItemModel;
import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.panel.*;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractMainCenterTablePanelClient;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractTableCenterStructurePanelClient;
import com.intellibucket.pipeql.view.client.main.concretes.TableCenterStructurePanelClient;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.util.BorderUtils;
import com.intellibucket.pipeql.view.util.ColorUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public
class TableCenterStructurePanel extends AbstractGSimplePanel {

    private final AbstractTableCenterStructurePanelClient client = new TableCenterStructurePanelClient();
    private final TableRoot tableRoot;
    private final HeaderOfTableCenterStructurePanel headerOfTableCenterStructurePanel;
    private final CenterOfTableCenterStructurePanel centerOfTableCenterStructurePanel;

    {
        this.setLayout(new BorderLayout());
    }

    public TableCenterStructurePanel(TableRoot tableRoot) {
        this.tableRoot = tableRoot;
        this.headerOfTableCenterStructurePanel = new HeaderOfTableCenterStructurePanel(tableRoot);
        this.centerOfTableCenterStructurePanel = new CenterOfTableCenterStructurePanel(tableRoot);
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

    private GItemTextFieldPanel tableNameTFPanel ;
    private GItemTextFieldPanel commentsTFPanel ;

    {
        this.setLayout(new GridLayout(1, 2));
    }

    public HeaderOfTableCenterStructurePanel(TableRoot tableRoot) {
        tableNameTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Table Name:");
        commentsTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Comments:");
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

    public CenterOfTableCenterStructurePanel(TableRoot tableRoot) {
        this.topPanel = new TopOfCenterOfTableCenterStructurePanel(tableRoot);
        this.bottomPanel = new BottomOfCenterOfTableCenterStructurePanel();
        this.splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, this.topPanel, this.bottomPanel);
        this.splitPane.setDividerLocation(300);
    }

    {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createLineBorder(ColorUtils.COLORFUL_BUTTON_BACKGROUND, 1));
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

    public TopOfCenterOfTableCenterStructurePanel(TableRoot tableRoot) {
        this.tabbedPaneOfTopOfCenterOfTableCenterStructurePanel = new TabbedPaneOfTopOfCenterOfTableCenterStructurePanel(tableRoot);
    }

    {
        this.setBorder(BorderFactory.createLineBorder(ColorUtils.COLORFUL_BUTTON_BACKGROUND, 1));
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

class MapperOfTopOfCenterOfTableCenterStructurePanel {
    public static List<AbstractGSimplePanel> map(List<ColumnRoot> columns) {
        return columns.stream().map(GColumnListItemPanel::new).collect(Collectors.toList());
    }
}

class TabbedPaneOfTopOfCenterOfTableCenterStructurePanel extends AbstractMaximizedGTabbedPane {
    private ItemWithBarPanel columnsPanel;
    private ItemWithBarPanel indexesPanel;
    private ItemWithBarPanel triggersPanel;
    private ItemWithBarPanel foreignKeysPanel;

    public TabbedPaneOfTopOfCenterOfTableCenterStructurePanel(TableRoot tableRoot) {
        this.columnsPanel = new ColumnsPanel(MapperOfTopOfCenterOfTableCenterStructurePanel.map(tableRoot.getColumns()));
        this.indexesPanel = new IndexesPanel(List.of());
        this.triggersPanel = new TriggersPanel(List.of());
        this.foreignKeysPanel = new ForeignKeysPanel(List.of());
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

    class ColumnsPanel extends ItemWithBarPanel{

        public ColumnsPanel(List<AbstractGSimplePanel> columns) {
            super(columns);
        }
    }

    class IndexesPanel extends ItemWithBarPanel{

        public IndexesPanel(List<AbstractGSimplePanel> columns) {
            super(columns);
        }
    }

    class TriggersPanel extends ItemWithBarPanel{

        public TriggersPanel(List<AbstractGSimplePanel> columns) {
            super(columns);
        }
    }

    class ForeignKeysPanel extends ItemWithBarPanel{

        public ForeignKeysPanel(List<AbstractGSimplePanel> columns) {
            super(columns);
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