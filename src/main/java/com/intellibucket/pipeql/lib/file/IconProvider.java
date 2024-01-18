package com.intellibucket.pipeql.lib.file;

import javax.swing.*;
import java.awt.*;

public class IconProvider {
    public static Icon getIcon(String name) {
        return IconContainer.getIcon(name);
    }

    public static Icon getIconWithSize(String name, Dimension dimension) {
        ImageIcon image = (ImageIcon) IconContainer.getIcon(name);
        var result = image.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        return new ImageIcon(result);
    }
}
