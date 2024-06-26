package com.intellibucket.pipeql.view.components.intro.screens;

import com.intellibucket.pipeql.domain.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.EventListener;
import com.intellibucket.pipeql.view.util.border.CustomBorderProvider;
import com.intellibucket.pipeql.lib.splitpane.GSplitPane;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.frame.concretes.SmallGFrame;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.leftPanel.NewProjectLeftSideMainPanel;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.centerPanel.NewProjectCenterMainPanel;
import com.intellibucket.pipeql.view.topics.NewProjectPanelTopics;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class NewProjectScreen extends SmallGFrame {
    private final NewProjectLeftSideMainPanel leftSideIntroductionPanel = new NewProjectLeftSideMainPanel();
    private final NewProjectCenterMainPanel newProjectCenterMainPanel = new NewProjectCenterMainPanel();
    private final JSplitPane splitPane;

    {
        this.setIconImage(ImageToolKit.getLogo().getImage());
        this.setTitle("New Project");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }

    public NewProjectScreen(AbstractGPanel abstractGPanel) {
        this.setLocationRelativeTo(abstractGPanel);
        this.splitPane = new GSplitPane(JSplitPane.HORIZONTAL_SPLIT,
                leftSideIntroductionPanel,
                newProjectCenterMainPanel,
                CustomBorderProvider.ONE_LINE_RIGHT_BORDER.getBorder(Color.BLACK));
        splitPane.setResizeWeight(0.25);
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.leftSideIntroductionPanel, this.newProjectCenterMainPanel);
    }

    @Override
    public void setComponents() {
        this.add(this.splitPane, BorderLayout.CENTER);
    }

    @Override
    public void setEventListener() {
        this.addEventListener(new EventListener<Payload, EmptySuccessPayload>(List.of(NewProjectPanelTopics.CLICKED_CANCEL_NEW_PROJECT)) {
            @Override
            protected EmptySuccessPayload listen(Payload message) throws DomainException {
                NewProjectScreen.this.dispose();
                return EmptySuccessPayload.INSTANCE;
            }
        });
    }

}
