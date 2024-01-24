package com.intellibucket.pipeql.view.components.databases.screen;

import com.intellibucket.pipeql.application.kernel.concretes.ApplicationKernel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.frame.concretes.MidGFrame;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.databases.panel.BottomDatabasePanel;
import com.intellibucket.pipeql.view.components.databases.panel.LeftSideDatabasesPanel;
import com.intellibucket.pipeql.view.components.databases.panel.center.EmptyCenterDatabasesPanel;

import java.awt.*;
import java.util.List;

public class DatabasesScreen extends MidGFrame {

    private final SimpleSideGPanel sidePanel;
    private final ChangeablePanel centerPanel;
    private final BottomDatabasePanel bottomPanel;

    {
        this.setLocationRelativeTo(ApplicationKernel.CURRENT_MAIN_SCREEN);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE );
    }

    public DatabasesScreen() {
        super("Databases and Drivers");
        this.sidePanel = new LeftSideDatabasesPanel();
        this.centerPanel = new EmptyCenterDatabasesPanel();
        this.bottomPanel = new BottomDatabasePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                sidePanel,
                centerPanel,
                bottomPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(sidePanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

}
