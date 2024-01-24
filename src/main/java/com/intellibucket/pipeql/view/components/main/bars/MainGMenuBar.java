package com.intellibucket.pipeql.view.components.main.bars;

import com.intellibucket.pipeql.lib.bar.GMenu;
import com.intellibucket.pipeql.lib.bar.GMenuBar;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.bars.menues.*;

import java.util.List;

public class MainGMenuBar extends GMenuBar {
    private final GMenu fileGMenu;

    private final GMenu editGMenu;

    private final GMenu viewGMenu;

    private final GMenu toolsGMenu;

    private final GMenu windowGMenu;

    private final GMenu helpGMenu;



    public MainGMenuBar() {
        this.fileGMenu = new FileGMenu();
        this.editGMenu = new EditGMenu();
        this.viewGMenu = new ViewGMenu();
        this.toolsGMenu = new ToolsGMenu();
        this.windowGMenu = new WindowsGMenu();
        this.helpGMenu = new HelpGMenu();
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.fileGMenu,
                this.editGMenu,
                this.viewGMenu,
                this.toolsGMenu,
                this.windowGMenu,
                this.helpGMenu
        );
    }

    @Override
    public void addComponents() {
        this.add(this.fileGMenu);
        this.add(this.editGMenu);
        this.add(this.viewGMenu);
        this.add(this.toolsGMenu);
        this.add(this.windowGMenu);
        this.add(this.helpGMenu);
    }
}
