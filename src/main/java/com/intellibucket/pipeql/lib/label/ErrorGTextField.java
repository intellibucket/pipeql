package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.lib.textField.CustomTextField;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.enums.CustomBorderProvider;

import java.awt.*;
import java.util.List;

public class ErrorGTextField extends CustomTextField {

    public ErrorGTextField(String text) {
        super(text);
        initConfig();
    }

    private void initConfig() {
        setForeground(Color.WHITE);
        setBackground(new Color(169, 73, 73));
        setOpaque(true);
        setBorder(CustomBorderProvider.ROUND_BORDER.getBorder(new Color(169, 73, 73)));
        setFont(getFont().deriveFont(Font.PLAIN, 10));
    }




    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}