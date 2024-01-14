package com.intellibucket.pipeql.view.components.main.panel;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.common.GroupID;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.consumer.ConsumerAggregate;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.lib.panel.main.AbstractResizeablePanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.panel.center.CenterInnerCenterPanel;
import com.intellibucket.pipeql.view.components.main.panel.center.LeftInnerCenterPanel;
import com.intellibucket.pipeql.view.components.main.panel.center.RightInnerCenterPanel;

import java.awt.*;
import java.util.List;

public class ResizeablePanel extends AbstractResizeablePanel {

    private final ListenerProjectButton listenerProjectButton = new ListenerProjectButton();

    public ResizeablePanel() {
        super(new LeftInnerCenterPanel(), new CenterInnerCenterPanel(), new RightInnerCenterPanel());
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

    class ListenerProjectButton extends Consumer<Payload, ListenerProjectButton.ListenerProjectButtonSuccessPayload> {

        class ListenerProjectButtonSuccessPayload extends SuccessPayload {
            private Boolean isClicked;

            ListenerProjectButtonSuccessPayload() {
                this.isClicked = true;
            }

            public Boolean getClicked() {
                return this.isClicked;
            }
        }

        {
            var consumerAggregate = new ConsumerAggregate(GroupID.DEFAULT, this);
            DefaultEventLinkBroker.Mediator.registerConsumer(new Topic("clicked.side-projects.button"), consumerAggregate);
        }

        @Override
        protected ListenerProjectButtonSuccessPayload proceed(Payload message) throws DomainException {
            //ResizeablePanel.this.openLeftBar();
            throw new DomainException("Bir hata oluştu.");
            //return new ListenerProjectButtonSuccessPayload();
        }
    }
}
