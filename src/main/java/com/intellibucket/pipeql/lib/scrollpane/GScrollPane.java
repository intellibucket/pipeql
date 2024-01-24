package com.intellibucket.pipeql.lib.scrollpane;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public class GScrollPane extends JScrollPane implements ComponentInitializer {
    private ComponentInitializer view;

    public GScrollPane(ComponentInitializer view, int vsbPolicy, int hsbPolicy) {
        super((Component) view, vsbPolicy, hsbPolicy);
        this.view = view;
    }

    public GScrollPane(ComponentInitializer view) {
        super((Component) view);
        this.view = view;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.view
        );
    }

    @Override
    public void setComponents() {

    }
}
