package com.intellibucket.pipeql.lib.file;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;
import com.intellibucket.pipeql.lib.icon.GFlatSVGIcon;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ImageContainer {
    public static final Image LOAD_IMAGE = Toolkit.getDefaultToolkit().getImage(AbstractApplicationProfileInitializer.PROFILE.resourcePath() + "pics/load.jpg");
    private static final Map<String, Icon> ICON_CONTAINER  = new HashMap<>();

    public static Icon getIcon(String name) {
        var result = ICON_CONTAINER.get(name);
        if (result == null) {
            result = ICON_CONTAINER.get("red");
        }
        return result;
    }

    public static void addIcon(String name, Icon icon) {
        ICON_CONTAINER.put(name, icon);
    }

    public static void addIcon(String name, String path) {
        ICON_CONTAINER.put(name, new ImageIcon(path));
    }

    public static void addIcon(String name, String path, int width, int height) {
        ICON_CONTAINER.put(name, new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH)));
    }

    public static void addIcon(String name, String path, int width, int height, int hints) {
        ICON_CONTAINER.put(name, new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, hints)));
    }


    public static void initialize(){
        ICON_CONTAINER.clear();
        var resourcePath = AbstractApplicationProfileInitializer.PROFILE.resourcePath();
        var iconPath = resourcePath + "icons/";
        Set<File> fileSet = new HashSet<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(iconPath))) {
            for (Path path : stream) {
                if (Files.isDirectory(path)) {
                    try(var walked = Files.walk(path)) {
                        var result = walked.filter(Files::isRegularFile)
                                .map(Path::toFile)
                                .collect(Collectors.toSet());
                        fileSet.addAll(result);
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        fileSet.stream().collect(Collectors.toMap(item->item.getName().split("\\.")[0], ImageContainer::fetch)).forEach(ImageContainer::addIcon);
    }

    public static Icon fetch(File file){
        return new GFlatSVGIcon(file);
    }


}
