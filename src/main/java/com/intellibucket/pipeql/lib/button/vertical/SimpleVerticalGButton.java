package com.intellibucket.pipeql.lib.button.vertical;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.util.List;

public class SimpleVerticalGButton extends AbstractVerticalGButton implements ComponentInitializer {

    public SimpleVerticalGButton(String text) {
        super(text);
    }

    public SimpleVerticalGButton(String text, Icon icon) {
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
