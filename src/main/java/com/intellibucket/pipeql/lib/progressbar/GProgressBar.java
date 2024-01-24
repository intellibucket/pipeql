package com.intellibucket.pipeql.lib.progressbar;

import com.intellibucket.pipeql.lib.ComponentInitializer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GProgressBar extends JProgressBar implements ComponentInitializer {
    {
        this.setStringPainted(false);
        this.setValue(1);
        this.setForeground(new Color(67, 187, 255));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }
}
