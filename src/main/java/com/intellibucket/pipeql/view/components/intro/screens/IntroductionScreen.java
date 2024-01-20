package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.frame.concretes.MidGFrame;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.EmptyCenterIntroPanel;
import com.intellibucket.pipeql.view.components.intro.panel.LeftSideIntroductionPanel;
import com.intellibucket.pipeql.view.components.intro.panel.ProjectsCenterIntroPanel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class IntroductionScreen extends MidGFrame {

    private final ChangeablePanelListener changeablePanelListener = new ChangeablePanelListener();

    private final JSplitPane splitPane;
    private final LeftSideIntroductionPanel leftSideIntroductionPanel;
    private ChangeablePanel centerChangeablePanel;


    {

        this.setPreferredSize(new Dimension(800, 600));
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
        this.setLocationRelativeTo(null);
    }

    public IntroductionScreen() {
        super("Welcome to PipeQL");
        this.leftSideIntroductionPanel = new LeftSideIntroductionPanel();
        this.centerChangeablePanel = new ProjectsCenterIntroPanel();
        this.splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, this.leftSideIntroductionPanel, this.centerChangeablePanel);
        this.splitPane.setDividerLocation(300);
    }

    private void changeCenterPanel(ChangeablePanel changeablePanel){
        this.centerChangeablePanel = changeablePanel;
        this.splitPane.setRightComponent(this.centerChangeablePanel);
        this.splitPane.setDividerLocation(300);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.leftSideIntroductionPanel,
                this.centerChangeablePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.splitPane);
    }

    public class ChangeablePanelListener extends Consumer<ChangeablePanelListener.ChangeablePanelPayload, EmptySuccessPayload>{

        public static class ChangeablePanelPayload implements Payload {
            private final ChangeablePanel changeablePanel;

            public ChangeablePanelPayload(ChangeablePanel changeablePanel) {
                this.changeablePanel = changeablePanel;
            }

            public ChangeablePanel getChangeablePanel() {
                return changeablePanel;
            }
        }


        @Override
        protected EmptySuccessPayload listen(ChangeablePanelPayload message) throws DomainException {
            IntroductionScreen.this.changeCenterPanel(message.getChangeablePanel());
            return EmptySuccessPayload.INSTANCE;
        }

        @Override
        protected List<Topic> mustBeRegistryTopics() {
            return List.of(new Topic("change-intro-screen-center-panel"));
        }
    }


}
