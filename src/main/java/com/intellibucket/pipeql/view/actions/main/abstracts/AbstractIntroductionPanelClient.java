package com.intellibucket.pipeql.view.actions.main.abstracts;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;

import java.util.Optional;

public interface AbstractIntroductionPanelClient {
    void newProject(AbstractGPanel abstractGPanel);
    void selectDirectory(AbstractGSimplePanel changeablePanel, AbstractGTextField textField);

    void createNewProject(String path);

    Optional<String> checkPath(String newProjectName, String newProjectPath);

    void openMainScreen(String path);

    void openProject(AbstractGPanel abstractGPanel);
}
