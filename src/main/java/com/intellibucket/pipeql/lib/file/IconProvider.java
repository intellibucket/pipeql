package com.intellibucket.pipeql.lib.file;

import javax.swing.*;

public class IconProvider {
    public static Icon getIcon(String name) {
        return IconContainer.getIcon(name);
    }

    public static Icon getIconLight(String name) {
        var image = IconContainer.getIcon(name);
        return IconContainer.getIcon(name);
    }
}
