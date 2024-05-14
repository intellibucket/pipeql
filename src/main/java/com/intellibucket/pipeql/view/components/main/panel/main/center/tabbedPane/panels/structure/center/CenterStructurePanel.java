package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure.center;

import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.domain.model.root.TableRoot;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.panel.*;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.panel.layout.BorderGSimplePanel;
import com.intellibucket.pipeql.view.actions.payloads.TableDataPayload;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

import static com.intellibucket.pipeql.view.topics.CenterStructurePanelTopics.TABLE_SELECTED;

@Slf4j
public class CenterStructurePanel extends BorderGSimplePanel {

    private AbstractGSimplePanel mainPanel;

    public CenterStructurePanel(TableRoot tableRoot) {
        this.mainPanel = new TableCenterStructurePanel(tableRoot);
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
                CenterStructurePanel.this.changeMainPanel(new TableCenterStructurePanel(tableData));
                return EmptySuccessPayload.INSTANCE;
            }
        });
    }
}


