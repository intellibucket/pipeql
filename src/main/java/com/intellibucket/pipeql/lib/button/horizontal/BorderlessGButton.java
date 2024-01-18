package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BorderlessGButton extends SimpleGButton{

    {
        this.setSize(new Dimension(100,30));
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public BorderlessGButton(String text) {
        super(text);
    }

    public BorderlessGButton(String text, Icon icon) {
        super(text, icon);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
