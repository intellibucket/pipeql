package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.lib.panel.main.AbstractResizeablePanel;
import com.intellibucket.pipeql.view.client.main.concretes.CenterPanelClient;
import com.intellibucket.pipeql.view.client.main.concretes.RightSidePanelClient;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.main.center.CenterInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.center.EmptyInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.left.LeftInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.right.RightInnerMainPanel;
import com.intellibucket.pipeql.view.topics.LeftMainPanelTopics;
import com.intellibucket.pipeql.view.topics.RightMainPanelTopics;

import java.awt.*;
import java.util.List;

public class MainResizeablePanel extends AbstractResizeablePanel {

    private final NotificationButtonListener notificationButtonListener = new NotificationButtonListener();
    private final ProjectButtonListener projectButtonListener = new ProjectButtonListener();
    private final CloseAllCenterPanelListener closeAllCenterPanelListener = new CloseAllCenterPanelListener();

    public MainResizeablePanel() {
        super(new LeftInnerMainPanel(), new CenterInnerMainPanel(), new RightInnerMainPanel());
        this.getRightPanel().setBackground(Color.RED);
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
    public void addComponents() {
        this.add(this.getCenterRightSplitPanel(), BorderLayout.CENTER);
    }

    class NotificationButtonListener extends Consumer<Payload, EmptySuccessPayload> {

        @Override
        protected EmptySuccessPayload listen(Payload message) throws DomainException {
            MainResizeablePanel.this.openRightBar();
            return EmptySuccessPayload.INSTANCE;
        }

        @Override
        protected List<Topic> mustBeRegistryTopics() {
            return List.of(RightMainPanelTopics.CLICKED_OPEN_NOTIFICATION_SIDE_BAR);
        }
    }

    class ProjectButtonListener extends Consumer<Payload, ProjectButtonListener.ListenerProjectButtonSuccessPayload> {

        static class ListenerProjectButtonSuccessPayload extends SuccessPayload {
            private final Boolean isClicked;

            ListenerProjectButtonSuccessPayload() {
                this.isClicked = true;
            }

            public Boolean getClicked() {
                return this.isClicked;
            }
        }

        @Override
        protected ListenerProjectButtonSuccessPayload listen(Payload message) throws DomainException {
            MainResizeablePanel.this.openLeftBar();
            return new ListenerProjectButtonSuccessPayload();
        }

        @Override
        protected List<Topic> mustBeRegistryTopics() {
            return List.of((LeftMainPanelTopics.CLICKED_SIDE_PROJECTS_BUTTON));
        }
    }

    class CloseAllCenterPanelListener extends Consumer<Payload, CloseAllCenterPanelListener.ListenerCloseAllCenterPanelSuccessPayload> {

        static class ListenerCloseAllCenterPanelSuccessPayload extends SuccessPayload {}

        @Override
        protected ListenerCloseAllCenterPanelSuccessPayload listen(Payload message) throws DomainException {
            MainResizeablePanel.this.setCenterPanel(new EmptyInnerMainPanel());
            return new ListenerCloseAllCenterPanelSuccessPayload();
        }

        @Override
        protected List<Topic> mustBeRegistryTopics() {
            return List.of(CenterPanelClient.Topics.CLOSE_ALL_SCHEMAS_TOPIC);
        }
    }
}
