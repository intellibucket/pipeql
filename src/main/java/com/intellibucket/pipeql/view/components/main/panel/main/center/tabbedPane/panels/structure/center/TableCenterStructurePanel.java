package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure.center;

import com.intellibucket.pipeql.domain.model.root.ColumnRoot;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleOkGButton;
import com.intellibucket.pipeql.lib.panel.*;
import com.intellibucket.pipeql.lib.tabbed.AbstractMaximizedGTabbedPane;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractTableCenterStructurePanelClient;
import com.intellibucket.pipeql.view.actions.main.concretes.TableCenterStructurePanelClient;
import com.intellibucket.pipeql.view.components.main.panel.InnerResizeablePanel;
import com.intellibucket.pipeql.view.util.border.BorderUtils;
import com.intellibucket.pipeql.view.util.color.PaletteUtils;
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

    private final BottomOfTableCenterStructurePanel bottomOfTableCenterStructurePanel;

    {
        this.setLayout(new BorderLayout());
    }

    public TableCenterStructurePanel(TableRoot tableRoot) {
        this.tableRoot = tableRoot;
        this.headerOfTableCenterStructurePanel = new HeaderOfTableCenterStructurePanel(tableRoot);
        this.centerOfTableCenterStructurePanel = new CenterOfTableCenterStructurePanel(tableRoot);
        this.bottomOfTableCenterStructurePanel = new BottomOfTableCenterStructurePanel();
    }


    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return java.util.List.of(
                this.headerOfTableCenterStructurePanel,
                this.centerOfTableCenterStructurePanel,
                this.bottomOfTableCenterStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.headerOfTableCenterStructurePanel, BorderLayout.NORTH);
        this.add(this.centerOfTableCenterStructurePanel, BorderLayout.CENTER);
        this.add(this.bottomOfTableCenterStructurePanel, BorderLayout.SOUTH);
    }

}

class HeaderOfTableCenterStructurePanel extends TransparentGPanel {

    private GItemTextFieldPanel tableNameTFPanel ;
    private GItemTextFieldPanel commentsTFPanel ;

    {
        this.setLayout(new GridLayout(1, 2));
    }

    public HeaderOfTableCenterStructurePanel(TableRoot tableRoot) {
        tableNameTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Table Name:", tableRoot.getName());
        commentsTFPanel = new HeaderOfTableCenterStructurePanel.ItemTextFieldPanel("Comments:", tableRoot.getComments());
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

        public ItemTextFieldPanel(String label, String value) {
            super(label, value);
        }
    }

}

class BottomOfTableCenterStructurePanel extends TransparentGPanel{
    private AbstractGPanel label;
    private LeftOfBottomOfTableCenterStructurePanel leftOfBottomOfTableCenterStructurePanel = new LeftOfBottomOfTableCenterStructurePanel();

    {
        this.setLayout(new BorderLayout());
    }

    public BottomOfTableCenterStructurePanel() {
        this.label = LabelPairPanel.Prototype.success("Relax! All changes were saved successfully.");
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.label,
                this.leftOfBottomOfTableCenterStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.label, BorderLayout.WEST);
        this.add(this.leftOfBottomOfTableCenterStructurePanel, BorderLayout.EAST);
    }


    class LeftOfBottomOfTableCenterStructurePanel extends TransparentGPanel {
        private AbstractGButton addColumnButton = new SimpleOkGButton("Apply");
        private AbstractGButton deleteColumnButton = new SimpleGButton("Cancel");

        {
            this.setBorder(BorderUtils.EMPTY_BORDER_5_5_5_5);
            this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.addColumnButton,
                    this.deleteColumnButton
            );
        }

        @Override
        public void setComponents() {
            this.add(this.addColumnButton);
            this.add(this.deleteColumnButton);
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
        this.setBorder(BorderFactory.createLineBorder(PaletteUtils.COLORFUL_BUTTON_BACKGROUND, 1));
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
        this.setBorder(BorderFactory.createLineBorder(PaletteUtils.COLORFUL_BUTTON_BACKGROUND, 1));
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