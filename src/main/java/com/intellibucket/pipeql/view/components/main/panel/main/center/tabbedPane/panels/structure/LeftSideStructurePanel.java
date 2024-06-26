package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractSchemaDetailService;
import com.intellibucket.pipeql.domain.port.input.service.factory.DetailServiceFactory;
import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.combo.GComboBox;
import com.intellibucket.pipeql.lib.combo.GComboBoxItem;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.list.GList;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.lib.scrollpane.GScrollPane;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractMainCenterTablePanelClient;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractSchemaComboBoxClient;
import com.intellibucket.pipeql.view.actions.main.concretes.MainCenterTablePanelClient;
import com.intellibucket.pipeql.view.actions.main.concretes.SchemaComboBoxClient;
import com.intellibucket.pipeql.view.actions.payloads.SchemaItemModelPayload;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.domain.model.dto.response.project.ProjectModel;
import com.intellibucket.pipeql.domain.model.dto.response.schema.SchemaItemModel;
import com.intellibucket.pipeql.domain.model.dto.response.table.TableItemModel;
import com.intellibucket.pipeql.view.topics.SchemaComboBoxTopics;
import com.intellibucket.pipeql.view.util.border.BorderUtils;
import com.intellibucket.pipeql.view.util.FontsUtil;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Objects;

@Slf4j
public class LeftSideStructurePanel extends AbstractGSimplePanel {

    private final AbstractSchemaDetailService schemaDetailService = DetailServiceFactory.factorySchemaDetailService();
    private HeaderOfLeftSideStructurePanelLine headerOfLeftSideStructurePanel;
    private ListTablesOfLeftSideStructurePanelLine listTablesOfLeftSideStructurePanel;

    {
        this.setLayout(new BorderLayout());
        this.setBorder(BorderUtils.EMPTY_BORDER_5_0_5_0);
    }

    public LeftSideStructurePanel(ProjectModel projectModel) {
        var schemasFrom = this.schemaDetailService.findAllSimpleItem();
        headerOfLeftSideStructurePanel = new HeaderOfLeftSideStructurePanelLine(schemasFrom);
        listTablesOfLeftSideStructurePanel = new ListTablesOfLeftSideStructurePanelLine(this.getCurrentSchema().tables());
    }

    protected void changeListTablesOfLeftSideStructurePanelLine(List<TableItemModel> tables) {
        var newListTablesOfLeftSideStructurePanel = new ListTablesOfLeftSideStructurePanelLine(tables);
        this.remove(listTablesOfLeftSideStructurePanel);
        this.add(newListTablesOfLeftSideStructurePanel, BorderLayout.CENTER);
        this.listTablesOfLeftSideStructurePanel = newListTablesOfLeftSideStructurePanel;
        this.listTablesOfLeftSideStructurePanel.initialize();
        this.revalidate();
        this.repaint();
        log.info("Schema changed..");
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerOfLeftSideStructurePanel,
                this.listTablesOfLeftSideStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.headerOfLeftSideStructurePanel, BorderLayout.NORTH);
        this.add(this.listTablesOfLeftSideStructurePanel, BorderLayout.CENTER);
    }

    @Override
    public void setEventPublisher() {
        super.setEventPublisher();
        this.addEventListener(new EventListener<SchemaItemModelPayload, EmptySuccessPayload>(List.of(SchemaComboBoxTopics.CHANGED_SELECTED_SCHEMA_ON_COMBOBOX)) {
            @Override
            protected EmptySuccessPayload listen(SchemaItemModelPayload message) throws DomainException {
                var tables = message.getSchema().tables();
                LeftSideStructurePanel.this.changeListTablesOfLeftSideStructurePanelLine(tables);
                return EmptySuccessPayload.INSTANCE;
            }
        });
    }

    public SchemaItemModel getCurrentSchema() {
        return this.headerOfLeftSideStructurePanel.getSelectedSchema();
    }

    class ListTablesOfLeftSideStructurePanelLine extends AbstractGSimplePanel {

        private final CustomGList list;
        private final GScrollPane scrollPane;

        {
            this.setLayout(new BorderLayout());
        }

        public ListTablesOfLeftSideStructurePanelLine(List<TableItemModel> items) {
            super();
            var itemsPanel = items.stream().map(GListItemPanel::new).toList();
            this.list = new CustomGList(itemsPanel);
            this.scrollPane = new GScrollPane(this.list);
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(
                    this.scrollPane
            );
        }

        @Override
        public void setComponents() {
            this.add(this.scrollPane, BorderLayout.CENTER);
        }


        class CustomGList extends GList {
            private final AbstractMainCenterTablePanelClient mainCenterTablePanelClient = new MainCenterTablePanelClient();
            public CustomGList(List<GListItemPanel> items) {
                super(items);
            }

            @Override
            public void setEventPublisher() {
                this.addListSelectionListener(e -> {
                    if (!e.getValueIsAdjusting()) {
                        var selectedValue = this.getSelectedValue();
                        if (Objects.nonNull(selectedValue)) {
                            var tableItemModel = selectedValue.getItem();
                            log.info("Selected table: {}", tableItemModel);
                            mainCenterTablePanelClient.openTable(tableItemModel.getDomainId());
                        }
                    }
                });
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
        public void setComponents() {
            this.add(headerLabel, BorderLayout.NORTH);
            this.add(schemasOfLeftSideStructurePanel, BorderLayout.CENTER);
            this.add(headerOfLeftSideStructurePanelLineLeft, BorderLayout.SOUTH);
        }

        public SchemaItemModel getSelectedSchema() {
            return this.schemasOfLeftSideStructurePanel.getSelectedSchema();
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

            public SchemaItemModel getSelectedSchema() {
                return ((SchemaComboItem) Objects.requireNonNull(this.schemaComboBox.getSelectedItem())).schema;
            }


            @Override
            public List<ComponentInitializer> getComponentInitializers() {
                return List.of(
                        this.schemaComboBox,
                        this.buttonsPanelOfSchemasOfLeftSideStructurePanel
                );
            }

            @Override
            public void setComponents() {
                this.add(this.buttonsPanelOfSchemasOfLeftSideStructurePanel, BorderLayout.WEST);
                this.add(this.schemaComboBox, BorderLayout.CENTER);
            }

            class ButtonsPanelOfSchemasOfLeftSideStructurePanel extends AbstractGSimplePanel {
                private final AbstractGButton addSchemaButton = new SimpleIconGButton("dataSchema");
                private final AbstractGButton editSchemaButton = new SimpleIconGButton("external_schema_object");

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
                public void setComponents() {
                    this.add(this.addSchemaButton);
                    this.add(this.editSchemaButton);
                }
            }

            static class SchemaComboBox extends GComboBox {
                private AbstractSchemaComboBoxClient client = new SchemaComboBoxClient();
                private SchemaComboBox(DefaultComboBoxModel<GComboBoxItem> model) {
                    super(model);
                }

                {
                    this.addActionListener(e -> {
                        var selectedItem = (SchemaComboItem) this.getSelectedItem();
                        this.client.changeSchema(selectedItem.schema);
                    });
                }

                public static SchemaComboBox of(List<SchemaComboItem> items) {
                    DefaultComboBoxModel<GComboBoxItem> model = new DefaultComboBoxModel<>();
                    items.forEach(model::addElement);
                    return new SchemaComboBox(model);
                }

            }

            class SchemaComboItem extends GComboBoxItem {

                private SchemaItemModel schema;
                private final AbstractGLabel nameLabel;

                SchemaComboItem(SchemaItemModel schema) {
                    this.nameLabel = new SimpleGLabel(schema.name());
                    this.schema = schema;
                }


                @Override
                public List<ComponentInitializer> getComponentInitializers() {
                    return List.of(
                            this.nameLabel
                    );
                }

                @Override
                public void setComponents() {
                    this.add(this.nameLabel);
                }


                @Override
                public String toString() {
                    return this.schema.name();
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
            public void setComponents() {
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
                public void setComponents() {
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
                public void setComponents() {
                    this.add(this.undoButton);
                    this.add(this.redoButton);
                }

            }

        }
    }
}





