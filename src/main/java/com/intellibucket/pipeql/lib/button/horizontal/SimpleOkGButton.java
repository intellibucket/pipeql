package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.ColorUtils;

import javax.swing.*;
import java.util.List;

public class SimpleOkGButton extends SimpleGButton{

    {
        this.setBackground(ColorUtils.COLORFUL_BUTTON_HOVER_BACKGROUND);
        this.setForeground(ColorUtils.COLORFUL_BUTTON_TEXT_COLOR);
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
