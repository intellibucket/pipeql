package com.intellibucket.pipeql.view.components.load.screens;

import com.intellibucket.pipeql.lib.frame.concretes.LoadGFrame;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.ImageGPanel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;
import com.intellibucket.pipeql.lib.progressbar.GProgressBar;
import com.intellibucket.pipeql.view.components.ApplicationLogoHeaderPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class LoadScreen extends LoadGFrame {

    private final AbstractGPanel panel = new MainImagePanel();
    private final GProgressBar progressBar = new GProgressBar();


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.panel,
                this.progressBar
        );
    }

    @Override
    public void addComponents() {
        this.add(this.panel, BorderLayout.CENTER);
        this.add(this.progressBar, BorderLayout.SOUTH);
    }

    @Override
    public void incrementProgress() {
        this.progressBar.setValue(this.progressBar.getValue() + 1);
    }
}

class MainImagePanel extends ImageGPanel{

    private final TransportLoadApplicationLogoHeaderPanel textPanelOfLoadScreen = new TransportLoadApplicationLogoHeaderPanel();

    {
        this.setLayout(new BorderLayout());
    }
    public MainImagePanel() {
        super("pics/load.jpg");
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.textPanelOfLoadScreen
        );
    }

    @Override
    public void addComponents() {
        this.add(this.textPanelOfLoadScreen, BorderLayout.WEST);
    }
}

class TransportLoadApplicationLogoHeaderPanel extends TransparentGPanel{

    private final LoadApplicationLogoHeaderPanel textPanelOfLoadScreen = new LoadApplicationLogoHeaderPanel();

    {
        this.setLayout(new BorderLayout());
    }
    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.textPanelOfLoadScreen
        );
    }

    @Override
    public void addComponents() {
        this.add(this.textPanelOfLoadScreen, BorderLayout.NORTH);
    }
}

class LoadApplicationLogoHeaderPanel extends ApplicationLogoHeaderPanel{
    {
        this.getNameVersionPanel().getApplicationNameLabel().setFont(new Font("Raleway", Font.BOLD, 40));
    }
}