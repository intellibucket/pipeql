package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractIntroductionPanelClient;
import com.intellibucket.pipeql.view.components.intro.screens.NewProjectScreen;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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


    public Optional<String> checkPath(String newProjectName, String newProjectPath) {
        String msg = null;
        if (Objects.isNull(newProjectName) ||
                newProjectName.isEmpty() ||
                Objects.isNull(newProjectPath) ||
                newProjectPath.isEmpty())
            msg =  "Field must be set";
        else if (isIllegalStartExpression(newProjectPath))
            msg =  "Must start with Latin character or '_'";

        else if (hasInvalidCharacter(newProjectPath))
            msg =  "Only Latin characters, digits,'_', '-' and '.' are allowed here";
        return Optional.ofNullable(msg);

    }

    private boolean isIllegalStartExpression(String text) {
        var firstSymbol = text.charAt(0);
        return firstSymbol != '_' && !Character.isLetter(firstSymbol);
    }

    private boolean hasInvalidCharacter(String text) {
        var legalCharacters = List.of('_', '-', '.');
        var chars = text.toCharArray();
        for (char c : chars)
            if (!Character.isLetter(c) && !legalCharacters.contains(c))
                return true;
        return false;

    }
}
