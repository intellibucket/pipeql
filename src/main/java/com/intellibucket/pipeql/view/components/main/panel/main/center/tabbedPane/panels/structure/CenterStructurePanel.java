package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure;

import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.payload.EmptyPayload;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.domain.model.dto.response.table.TableItemModel;
import com.intellibucket.pipeql.view.client.payloads.TableDataPayload;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static com.intellibucket.pipeql.view.topics.CenterStructurePanelTopics.TABLE_SELECTED;

@Slf4j
public class CenterStructurePanel extends AbstractGSimplePanel {

    private AbstractGSimplePanel mainPanel;

    {
        this.setLayout(new BorderLayout());
    }

    public CenterStructurePanel(TableItemModel tableItemModel) {
        this.mainPanel = new TableCenterStructurePanel(tableItemModel);
    }

    public CenterStructurePanel() {
        this.mainPanel = new EmptyCenterStructurePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainPanel
        );
    }

    private void changeMainPanel(AbstractGSimplePanel panel) {
        this.remove(this.mainPanel);
        this.mainPanel = panel;
        this.add(this.mainPanel, BorderLayout.CENTER);
        this.refresh();
    }

    @Override
    public void setComponents() {
        this.add(this.mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void setEventListener() {
        this.addEventListener(new EventListener<TableDataPayload,SuccessPayload>(List.of(TABLE_SELECTED)) {
            @Override
            protected SuccessPayload listen(TableDataPayload message) throws DomainException {
                var tableData = message.getTable();
                log.info("Listen to table selected event {}", tableData);
                CenterStructurePanel.this.changeMainPanel(new TableCenterStructurePanel(null));
                return EmptySuccessPayload.INSTANCE;
            }
        });
    }
}


@Slf4j
class EmptyCenterStructurePanel extends AbstractGSimplePanel {

    private final AbstractGPanel labelBox = new LabelBox();

    {
        this.setLayout(new GridBagLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.labelBox
        );
    }

    @Override
    public void setComponents() {
        this.add(this.labelBox);
    }

    static class LabelBox extends AbstractGPanel {

        private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Search Table"),new BlueGLabel("Ctrl+Shift+T"));
        private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Chose and open table"),new BlueGLabel(""));

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(this.firstLine,this.secondLine);
        }

        @Override
        public void setComponents() {
            this.add(this.firstLine);
            this.add(this.secondLine);
        }
    }
}

@Slf4j
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
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerOfTableCenterStructurePanel,
                this.centerOfTableCenterStructurePanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.headerOfTableCenterStructurePanel, BorderLayout.NORTH);
        this.add(this.centerOfTableCenterStructurePanel, BorderLayout.CENTER);
    }

    class HeaderOfTableCenterStructurePanel extends TransparentGPanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }

    class CenterOfTableCenterStructurePanel extends TransparentGPanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void setComponents() {

        }
    }




}