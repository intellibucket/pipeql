package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BlueGLabel extends AbstractGLabel{

    {
        this.setForeground(new Color(67, 187, 255));
    }

    public BlueGLabel() {
    }

    public BlueGLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public BlueGLabel(Icon image) {
        super(image);
    }

    public BlueGLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public BlueGLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public BlueGLabel(String text) {
        super(text);
        this.setFont(new Font("Arial", Font.PLAIN, 17));
    }

    public BlueGLabel(String text,Font font) {
        super(text);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
