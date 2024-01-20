package com.intellibucket.pipeql.lib.file;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;

import javax.swing.*;
import java.awt.*;

public class ImageToolKit {
    public static Icon getIcon(String name) {
        return ImageContainer.getIcon(name);
    }

    public static Icon getIconWithSize(String name, Dimension dimension) {
        ImageIcon image = (ImageIcon) ImageContainer.getIcon(name);
        var result = image.getImage().getScaledInstance(dimension.width, dimension.height, Image.SCALE_SMOOTH);
        return new ImageIcon(result);
    }

    public static ImageIcon getLogo() {
        var path = AbstractApplicationProfileInitializer.PROFILE.resourcePath() + "pics/logo.png";
        var image =  new ImageIcon(path);
        return new ImageIcon(image.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH));
    }
}