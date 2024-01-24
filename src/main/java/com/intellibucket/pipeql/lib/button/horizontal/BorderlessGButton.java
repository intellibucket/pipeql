package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BorderlessGButton extends SimpleGButton{

    {
        this.setFont(new Font("Arial", Font.PLAIN, 15));
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public BorderlessGButton(String text) {
        super(text);
    }

    public BorderlessGButton(String text, Icon icon) {
        super(text, icon);
    }
    public BorderlessGButton( Icon icon) {
        super("", icon);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
