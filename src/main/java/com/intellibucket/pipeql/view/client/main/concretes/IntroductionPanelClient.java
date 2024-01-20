package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractIntroductionPanelClient;
import com.intellibucket.pipeql.view.components.intro.screens.NewProjectScreen;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;

@Slf4j
public class IntroductionPanelClient implements AbstractIntroductionPanelClient {
    @Override
    public void newProject(AbstractGPanel abstractGPanel) {
        log.info("EmptyCenterIntroPanel.newProject");
        var newProjectScreen = new NewProjectScreen(abstractGPanel);
        newProjectScreen.initialize();

    }

    @Override
    public void selectDirectory(AbstractGSimplePanel changeablePanel, AbstractGTextField textField) {
        var fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        var result = fileChooser.showDialog(changeablePanel, "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            var selectedPath = fileChooser.getSelectedFile().getPath();
            textField.setText(selectedPath);
        }
    }
}
