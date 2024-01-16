package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class SimpleOkGButton extends SimpleGButton{

    {
        this.setBackground(new java.awt.Color(57, 167, 255));
        this.setForeground(Color.WHITE);
    }
    public SimpleOkGButton(String text) {
        super(text);
    }

    public SimpleOkGButton(String text, Icon icon) {
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
