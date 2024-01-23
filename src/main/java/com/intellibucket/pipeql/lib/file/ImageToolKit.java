package com.intellibucket.pipeql.lib.file;

import com.intellibucket.pipeql.application.profile.abstracts.AbstractApplicationProfileInitializer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageToolKit {
    public static Icon getIcon(String name) {
        return ImageContainer.getIcon(name);
    }

    public static Icon readPicture(String fullName) {
        try {
            return  new ImageIcon(ImageIO.read(new File(AbstractApplicationProfileInitializer.PROFILE.resourcePath() + fullName+"/"+fullName)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
