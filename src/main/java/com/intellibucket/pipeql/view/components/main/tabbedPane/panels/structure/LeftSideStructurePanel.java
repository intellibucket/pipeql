package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.list.GList;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;

import java.awt.*;
import java.util.List;
import java.util.UUID;

public class LeftSideStructurePanel extends AbstractGSimplePanel {

    private HeaderOfLeftSideStructurePanelLine headerOfLeftSideStructurePanel;
    private ListTablesOfLeftSideStructurePanelLine listTablesOfLeftSideStructurePanel;

    {
        this.setLayout(new BorderLayout());
    }

    public LeftSideStructurePanel() {
        headerOfLeftSideStructurePanel = new HeaderOfLeftSideStructurePanelLine();
        var table1 = new TableItemModel(UUID.randomUUID(), "user","users");
        var table2 = new TableItemModel(UUID.randomUUID(), "user","accounts");
        var table3 = new TableItemModel(UUID.randomUUID(), "user","profiles");
        var table4 = new TableItemModel(UUID.randomUUID(), "user","addresses");
        var table5 = new TableItemModel(UUID.randomUUID(), "user","phones");
        var table6 = new TableItemModel(UUID.randomUUID(), "user","contacts");
        var table7 = new TableItemModel(UUID.randomUUID(), "user","images");
        var table8 = new TableItemModel(UUID.randomUUID(), "user","posts");
        var table9 = new TableItemModel(UUID.randomUUID(), "user","comments");
        var table10 = new TableItemModel(UUID.randomUUID(), "user","likes");
        var list = List.of(table1, table2, table3, table4, table5, table6, table7, table8, table9, table10);
        listTablesOfLeftSideStructurePanel = new ListTablesOfLeftSideStructurePanelLine(list);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerOfLeftSideStructurePanel,
                this.listTablesOfLeftSideStructurePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.headerOfLeftSideStructurePanel, BorderLayout.NORTH);
        this.add(this.listTablesOfLeftSideStructurePanel, BorderLayout.CENTER);
    }

    class ListTablesOfLeftSideStructurePanelLine extends AbstractGSimplePanel{

        private final CustomGList list;

        {
            this.setLayout(new BorderLayout());
        }

        public ListTablesOfLeftSideStructurePanelLine(List<TableItemModel> items){
            super();
            var itemsPanel = items.stream().map(GListItemPanel::new).toList();
            this.list = new CustomGList(itemsPanel);
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.list
            );
        }

        @Override
        public void addComponents() {
            this.add(this.list.getScroll(), BorderLayout.CENTER);
        }

        class CustomGList extends GList{
            public CustomGList(List<GListItemPanel > items){
                super(items);
            }

        }
    }

    class HeaderOfLeftSideStructurePanelLine extends AbstractGSimplePanel{
        private final AbstractGLabel headerLabel = new SimpleGLabel("Schemas and Tables",new Font("Helvetica", Font.PLAIN, 15));

        private final HeaderOfLeftSideStructurePanel headerOfLeftSideStructurePanelLineLeft = new HeaderOfLeftSideStructurePanel();

        {
            this.setLayout(new BorderLayout());
        }
        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    headerOfLeftSideStructurePanelLineLeft,
                    headerLabel
            );
        }

        @Override
        public void addComponents() {
            this.add(headerLabel, BorderLayout.NORTH);
            this.add(headerOfLeftSideStructurePanelLineLeft, BorderLayout.SOUTH);
        }

        @Override
        public void postInitialize() {
            this.headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        }

        class HeaderOfLeftSideStructurePanel extends AbstractGSimplePanel {
            private final LeftPaneHeaderOfLeftSideStructurePanel leftPaneHeaderOfLeftSideStructurePanel = new LeftPaneHeaderOfLeftSideStructurePanel();
            private final RightPaneHeaderOfLeftSideStructurePanel rightPaneHeaderOfLeftSideStructurePanel = new RightPaneHeaderOfLeftSideStructurePanel();

            {
                this.setLayout(new BorderLayout());
            }

            @Override
            public List<ComponentInitializer> getComponentInitializers() {
                return List.of(
                        this.leftPaneHeaderOfLeftSideStructurePanel,
                        this.rightPaneHeaderOfLeftSideStructurePanel
                );
            }

            @Override
            public void addComponents() {
                this.add(this.leftPaneHeaderOfLeftSideStructurePanel, BorderLayout.WEST);
                this.add(this.rightPaneHeaderOfLeftSideStructurePanel, BorderLayout.EAST);
            }


            class LeftPaneHeaderOfLeftSideStructurePanel extends AbstractGSimplePanel {
                private final AbstractGButton addButton = new SimpleIconGButton("addBlankLine");
                private final AbstractGButton deleteButton = new SimpleIconGButton("remove");
                private final AbstractGButton duplicateButton = new SimpleIconGButton("duplicate");
                private final AbstractGButton goToDriverButton = new SimpleIconGButton("settings");
                private final AbstractGButton makeGlobal = new SimpleIconGButton("rspecSharedGroupRef");

                {
                    this.setLayout(new FlowLayout(FlowLayout.LEFT));
                }

                @Override
                public List<ComponentInitializer> getComponentInitializers() {
                    return List.of(
                            this.addButton,
                            this.deleteButton,
                            this.duplicateButton,
                            this.goToDriverButton,
                            this.makeGlobal
                    );
                }

                @Override
                public void addComponents() {
                    this.add(this.addButton);
                    this.add(this.deleteButton);
                    this.add(this.duplicateButton);
                    this.add(this.goToDriverButton);
                    this.add(this.makeGlobal);
                }

            }


            class RightPaneHeaderOfLeftSideStructurePanel extends AbstractGSimplePanel {

                private final AbstractGButton undoButton = new SimpleIconGButton("undo");
                private final AbstractGButton redoButton = new SimpleIconGButton("redo");

                {
                    this.setLayout(new FlowLayout(FlowLayout.RIGHT));
                }

                @Override
                public List<ComponentInitializer> getComponentInitializers() {
                    return List.of(
                            this.undoButton,
                            this.redoButton
                    );
                }

                @Override
                public void addComponents() {
                    this.add(this.undoButton);
                    this.add(this.redoButton);
                }

            }

        }
    }
}





