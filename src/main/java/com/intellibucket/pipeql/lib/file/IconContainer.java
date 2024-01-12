package com.intellibucket.pipeql.lib.file;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class IconContainer {
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
        var iconPath = resourcePath + "/icons/";
    }

}
