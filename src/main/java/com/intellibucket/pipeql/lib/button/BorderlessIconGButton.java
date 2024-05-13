package com.intellibucket.pipeql.lib.button;

import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.color.PaletteUtils;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BorderlessIconGButton extends SimpleGButton {

    {
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setBackground(PaletteUtils.TRANSPARENT);
    }

    public BorderlessIconGButton(String iconName) {
        super("", ImageToolKit.getIcon(iconName));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
