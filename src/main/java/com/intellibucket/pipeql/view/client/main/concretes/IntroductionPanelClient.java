package com.intellibucket.pipeql.view.client.main.concretes;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.MidGFrame;
import com.intellibucket.pipeql.lib.panel.SimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.view.client.main.abstracts.AbstractIntroductionPanelClient;
import com.intellibucket.pipeql.view.components.intro.screens.NewProjectScreen;
import com.intellibucket.pipeql.view.components.main.panel.main.right.EmptyChangeableSideBarPanel;
import com.intellibucket.pipeql.view.components.main.screens.MainScreen;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Slf4j
public class IntroductionPanelClient implements AbstractIntroductionPanelClient {
    public static String PROJECT_PATH;

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



    @Override
    public void createNewProject(String path) {
        try {
            createDirectory(path);
            var directoryMap = Map.of(
                    "alma", List.of("alma.json"),
                    "armud", List.of("armud.json"),
                    "heyva", List.of("heyva.json"),
                    "nar", List.of("nar.json")
            );
            directoryMap.entrySet()
                    .forEach(item -> {
                        try {
                            var directory = path.concat(File.separator).concat(item.getKey());
                            createDirectory(directory);
                            item.getValue()
                                    .forEach(file -> {
                                        try {
                                            createFile(directory.concat(File.separator).concat(file));
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    });
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createDirectory(String directoryPath) throws IOException {
        Path path = Paths.get(directoryPath);
        Files.createDirectories(path);
    }

    private static void createFile(String filePath) throws IOException {
        Path path = Paths.get(filePath);
        Files.createFile(path);
    }


    public Optional<String> checkPath(String newProjectName, String newProjectPath) {
        String msg = null;
        if (Objects.isNull(newProjectName) ||
                newProjectName.isEmpty() ||
                Objects.isNull(newProjectPath) ||
                newProjectPath.isEmpty())
            msg = "Field must be set";
        else if (isIllegalStartExpression(newProjectPath))
            msg = "Must start with Latin character or '_'";

        else if (hasInvalidCharacter(newProjectPath))
            msg = "Only Latin characters, digits,'_', '-' and '.' are allowed here";
        return Optional.ofNullable(msg);

    }

    @Override
    public void openMainScreen(String path) {
        PROJECT_PATH = path;
        var mainScreen = new MainScreen();
        mainScreen.initialize();

    }

    @Override
    public void openProject(AbstractGPanel abstractGPanel) {
        System.out.println("Alma");
        var fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        var result = fileChooser.showDialog(new EmptyChangeableSideBarPanel() , "Select");
        if (result == JFileChooser.APPROVE_OPTION) {
            PROJECT_PATH  = fileChooser.getSelectedFile().getPath();
            openMainScreen(PROJECT_PATH);

        }
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
