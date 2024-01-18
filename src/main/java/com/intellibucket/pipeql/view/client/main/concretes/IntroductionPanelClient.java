package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractIntroductionPanelClient;
import com.intellibucket.pipeql.view.components.intro.panel.newProject.NewProjectCenterPanel;
import com.intellibucket.pipeql.view.components.intro.screens.NewProjectScreen;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IntroductionPanelClient implements AbstractIntroductionPanelClient {
    @Override
    public void newProject(Callback callback) {
        log.info("EmptyCenterIntroPanel.newProject");
        var newProjectScreen = new NewProjectScreen();
        newProjectScreen.initialize();

    }
}
