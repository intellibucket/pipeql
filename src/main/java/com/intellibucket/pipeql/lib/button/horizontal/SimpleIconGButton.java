package com.intellibucket.pipeql.lib.button.horizontal;

import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public class SimpleIconGButton extends AbstractGButton{

    public SimpleIconGButton(String iconName) {
        super(ImageToolKit.getIcon(iconName));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
