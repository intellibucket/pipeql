package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.util.ColorsUtil;

import javax.swing.*;
import java.util.List;

public class SimpleOkGButton extends SimpleGButton{

    {
        this.setBackground(ColorsUtil.COLORFUL_BUTTON_HOVER_BACKGROUND);
        this.setForeground(ColorsUtil.COLORFUL_BUTTON_TEXT_COLOR);
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
