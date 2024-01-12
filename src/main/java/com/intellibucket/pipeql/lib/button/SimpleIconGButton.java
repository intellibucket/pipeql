package com.intellibucket.pipeql.lib.button;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import java.util.List;

public class SimpleIconGButton extends AbstractGButton{

    public SimpleIconGButton(Icon icon) {
        super(icon);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
