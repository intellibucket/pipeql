package com.intellibucket.pipeql.view.components.main.bars.menues;

import com.intellibucket.pipeql.lib.bar.GMenu;
import com.intellibucket.pipeql.lib.bar.items.GMenuItem;
import com.intellibucket.pipeql.lib.bar.items.SimpleGMenuItem;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.util.List;

public class FileGMenu extends GMenu {
    private GMenuItem newGMenuItem = new SimpleGMenuItem("New");
    private GMenuItem openGMenuItem = new SimpleGMenuItem("Open");
    private GMenuItem saveGMenuItem = new SimpleGMenuItem("Save");
    private GMenuItem saveAsGMenuItem = new SimpleGMenuItem("Save As");
    private GMenuItem exitGMenuItem = new SimpleGMenuItem("Exit");


    public FileGMenu() {
        super("File");
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.newGMenuItem,
                this.openGMenuItem,
                this.saveGMenuItem,
                this.saveAsGMenuItem,
                this.exitGMenuItem
        );
    }

    @Override
    public void addComponents() {
        this.add(this.newGMenuItem);
        this.add(this.openGMenuItem);
        this.add(this.saveGMenuItem);
        this.add(this.saveAsGMenuItem);
        this.add(this.exitGMenuItem);
    }
}
