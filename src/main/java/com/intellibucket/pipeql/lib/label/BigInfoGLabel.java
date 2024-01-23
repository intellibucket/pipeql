package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.util.ColorsUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BigInfoGLabel extends AbstractGLabel{

    {
        this.setForeground(Color.LIGHT_GRAY);
        this.setFont(new Font("Helvetica", Font.PLAIN, 15));
    }

    public BigInfoGLabel() {
    }

    public BigInfoGLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public BigInfoGLabel(Icon image) {
        super(image);
    }

    public BigInfoGLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public BigInfoGLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public BigInfoGLabel(String text) {
        super(text);
        this.setBackground(ColorsUtil.TRANSPARENT);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
