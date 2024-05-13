package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.color.PaletteUtils;

import javax.swing.*;
import java.util.List;

public class SimpleOkGButton extends SimpleGButton{

    {
        this.setBackground(PaletteUtils.COLORFUL_BUTTON_HOVER_BACKGROUND);
        this.setForeground(PaletteUtils.COLORFUL_BUTTON_TEXT_COLOR);
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
    public void setComponents() {

    }
}
