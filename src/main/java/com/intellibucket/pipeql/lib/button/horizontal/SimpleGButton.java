package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.util.List;

public class SimpleGButton extends AbstractGButton{
    public SimpleGButton(String text) {
        super(text);
    }

    public SimpleGButton() {
        super("Untitled");
    }



    public SimpleGButton(Icon icon) {
        super(icon);
    }

    public SimpleGButton(String text, Icon icon) {
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
