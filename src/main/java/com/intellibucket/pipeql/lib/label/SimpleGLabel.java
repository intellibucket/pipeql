package com.intellibucket.pipeql.lib.label;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.util.List;

public class SimpleGLabel extends AbstractGLabel{
    public SimpleGLabel() {
    }

    public SimpleGLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public SimpleGLabel(Icon image) {
        super(image);
    }

    public SimpleGLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public SimpleGLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public SimpleGLabel(String text) {
        super(text);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {}
}
