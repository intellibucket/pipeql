package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.lib.panel.main.AbstractResizeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.main.CenterInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.left.LeftInnerMainPanel;
import com.intellibucket.pipeql.view.components.main.panel.main.RightInnerMainPanel;

import java.awt.*;
import java.util.List;

public class ResizeablePanel extends AbstractResizeablePanel {

    private final ProjectButtonListener projectButtonListener = new ProjectButtonListener();

    public ResizeablePanel() {
        super(new LeftInnerMainPanel(), new CenterInnerMainPanel(), new RightInnerMainPanel());
        this.getLeftPanel().setBackground(Color.BLUE);
        this.getCenterPanel().setBackground(Color.GREEN);
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

        {
            DefaultEventLinkBroker.Mediator.registerConsumer(LeftSidePanel.Topics.CLICKED_SIDE_PROJECTS_BUTTON, this);
        }

        @Override
        protected ListenerProjectButtonSuccessPayload fire(Payload message) throws DomainException {
            ResizeablePanel.this.openLeftBar();
            return new ListenerProjectButtonSuccessPayload();
        }
    }
}
