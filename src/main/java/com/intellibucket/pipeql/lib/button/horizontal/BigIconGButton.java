package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class BigIconGButton extends AbstractGButton{

    {
        this.setPreferredSize(new Dimension(70, 70));
        this.setBackground(new Color(51, 92, 168));
    }

    public BigIconGButton(String iconName) {
        super(ImageToolKit.getIconWithSize(iconName, new Dimension(25, 25)));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
