package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.lib.panel.main.AbstractResizeablePanel;
import com.intellibucket.pipeql.view.actions.main.concretes.CenterPanelClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.main.center.CenterInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.center.EmptyInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.left.LeftInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.right.RightInnerMainPanel;
import com.intellibucket.pipeql.view.topics.LeftMainPanelTopics;
import com.intellibucket.pipeql.view.topics.RightMainPanelTopics;

import java.awt.*;
import java.util.List;

public class MainResizeablePanel extends AbstractResizeablePanel {

    public MainResizeablePanel() {
        super(new LeftInnerMainPanel(), new CenterInnerMainPanel(), new RightInnerMainPanel());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.getLeftPanel(),
                this.getCenterPanel(),
                this.getRightPanel()
        );
    }

    @Override
    public void setComponents() {
        this.add(this.getCenterRightSplitPanel(), BorderLayout.CENTER);
    }

    @Override
    public void setEventListener() {
        this.addEventListener(new EventListener<Payload, EmptySuccessPayload>(List.of(RightMainPanelTopics.CLICKED_OPEN_NOTIFICATION_SIDE_BAR)) {
            @Override
            protected EmptySuccessPayload listen(Payload message) throws DomainException {
                MainResizeablePanel.this.openRightBar();
                return EmptySuccessPayload.INSTANCE;
            }
        });

        this.addEventListener(new EventListener<Payload, EmptySuccessPayload>(List.of(LeftMainPanelTopics.CLICKED_SIDE_PROJECTS_BUTTON)) {
            @Override
            protected EmptySuccessPayload listen(Payload message) throws DomainException {
                MainResizeablePanel.this.openLeftBar();
                return EmptySuccessPayload.INSTANCE;
            }

        });

        this.addEventListener(new EventListener<>(List.of(CenterPanelClient.Topics.CLOSE_ALL_SCHEMAS_TOPIC)) {
            @Override
            protected SuccessPayload listen(Payload message) throws DomainException {
                MainResizeablePanel.this.setCenterPanel(new EmptyInnerMainPanel());
                return EmptySuccessPayload.INSTANCE;
            }
        });
    }

}
