package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.combo.GComboBox;
import com.intellibucket.pipeql.lib.combo.GComboBoxItem;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.list.GList;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.view.client.main.concretes.MockSchemaItemClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.SchemaItemModel;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;
import com.intellibucket.pipeql.view.util.FontsUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LeftSideStructurePanel extends AbstractGSimplePanel {

    private HeaderOfLeftSideStructurePanelLine headerOfLeftSideStructurePanel;
    private ListTablesOfLeftSideStructurePanelLine listTablesOfLeftSideStructurePanel;

    {
        this.setLayout(new BorderLayout());
    }

    public LeftSideStructurePanel() {
        var schemas = MockSchemaItemClient.getSchemas();
        headerOfLeftSideStructurePanel = new HeaderOfLeftSideStructurePanelLine(schemas);
        listTablesOfLeftSideStructurePanel = new ListTablesOfLeftSideStructurePanelLine(schemas.stream().flatMap(schemaItemModel -> schemaItemModel.tables().stream()).toList());
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

    class ListTablesOfLeftSideStructurePanelLine extends AbstractGSimplePanel {

        private final CustomGList list;

        {
            this.setLayout(new BorderLayout());
        }

        public ListTablesOfLeftSideStructurePanelLine(List<TableItemModel> items) {
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


        class CustomGList extends GList {
            public CustomGList(List<GListItemPanel> items) {
                super(items);
            }
        }
    }

    class HeaderOfLeftSideStructurePanelLine extends AbstractGSimplePanel {
        private final AbstractGLabel headerLabel = new SimpleGLabel("Schemas and Tables", FontsUtil.HELVETICA_BOLD_16);

        private final SchemasOfLeftSideStructurePanel schemasOfLeftSideStructurePanel;
        private final HeaderOfLeftSideStructurePanel headerOfLeftSideStructurePanelLineLeft;

        {
            this.setLayout(new BorderLayout());
        }

        public HeaderOfLeftSideStructurePanelLine(List<SchemaItemModel> schemas) {
            this.schemasOfLeftSideStructurePanel = new SchemasOfLeftSideStructurePanel(schemas);
            this.headerOfLeftSideStructurePanelLineLeft = new HeaderOfLeftSideStructurePanel();
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    headerOfLeftSideStructurePanelLineLeft,
                    schemasOfLeftSideStructurePanel,
                    headerLabel
            );
        }

        @Override
        public void addComponents() {
            this.add(headerLabel, BorderLayout.NORTH);
            this.add(schemasOfLeftSideStructurePanel, BorderLayout.CENTER);
            this.add(headerOfLeftSideStructurePanelLineLeft, BorderLayout.SOUTH);
        }

        @Override
        public void postInitialize() {
            this.headerLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        }


        class SchemasOfLeftSideStructurePanel extends AbstractGSimplePanel {

            private ButtonsPanelOfSchemasOfLeftSideStructurePanel buttonsPanelOfSchemasOfLeftSideStructurePanel = new ButtonsPanelOfSchemasOfLeftSideStructurePanel();
            private final SchemaComboBox schemaComboBox;

            {
                this.setLayout(new BorderLayout());
            }

            SchemasOfLeftSideStructurePanel(List<SchemaItemModel> items) {
                var schemaItems = items.stream().map(SchemasOfLeftSideStructurePanel.SchemaComboItem::new).toList();
                this.schemaComboBox = SchemaComboBox.of(schemaItems);
            }


            @Override
            public List<ComponentInitializer> getComponentInitializers() {
                return List.of(
                        this.schemaComboBox,
                        this.buttonsPanelOfSchemasOfLeftSideStructurePanel
                );
            }

            @Override
            public void addComponents() {
                this.add(this.buttonsPanelOfSchemasOfLeftSideStructurePanel, BorderLayout.WEST);
                this.add(this.schemaComboBox, BorderLayout.CENTER);
            }

            class ButtonsPanelOfSchemasOfLeftSideStructurePanel extends AbstractGSimplePanel {
                private final AbstractGButton addSchemaButton = new SimpleIconGButton("addBlankLine");
                private final AbstractGButton editSchemaButton = new SimpleIconGButton("editorPreview");

                {
                    this.setLayout(new FlowLayout(FlowLayout.LEFT));
                }

                @Override
                public List<ComponentInitializer> getComponentInitializers() {
                    return List.of(
                            this.addSchemaButton,
                            this.editSchemaButton
                    );
                }

                @Override
                public void addComponents() {
                    this.add(this.addSchemaButton);
                    this.add(this.editSchemaButton);
                }
            }

            static class SchemaComboBox extends GComboBox {
                private SchemaComboBox(DefaultComboBoxModel<GComboBoxItem> model) {
                    super(model);
                }

                public static SchemaComboBox of(List<SchemaComboItem> items) {
                    DefaultComboBoxModel<GComboBoxItem> model = new DefaultComboBoxModel<>();
                    items.forEach(model::addElement);
                    return new SchemaComboBox(model);
                }

            }

            class SchemaComboItem extends GComboBoxItem {

                private SchemaItemModel model;
                private final AbstractGLabel nameLabel;

                SchemaComboItem(SchemaItemModel model) {
                    this.nameLabel = new SimpleGLabel(model.name());
                    this.model = model;
                }


                @Override
                public List<ComponentInitializer> getComponentInitializers() {
                    return List.of(
                            this.nameLabel
                    );
                }

                @Override
                public void addComponents() {
                    this.add(this.nameLabel);
                }


                @Override
                public String toString() {
                    return this.model.name();
                }
            }

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





