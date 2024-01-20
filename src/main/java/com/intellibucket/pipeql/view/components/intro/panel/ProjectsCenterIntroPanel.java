package com.intellibucket.pipeql.view.components.intro.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.CustomTextField;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

public class ProjectsCenterIntroPanel extends ChangeablePanel {

    private final AbstractGPanel headerProjectsCenterIntroPanel = new HeaderProjectsCenterIntroPanel();
    private final AbstractGPanel bodyProjectsCenterIntroPanel = new BodyProjectsCenterIntroPanel();

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                headerProjectsCenterIntroPanel,
                bodyProjectsCenterIntroPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(headerProjectsCenterIntroPanel, BorderLayout.NORTH);
        this.add(bodyProjectsCenterIntroPanel, BorderLayout.CENTER);
    }
}


class HeaderProjectsCenterIntroPanel extends AbstractGPanel{

    private final AbstractGPanel leftHeaderProjectsCenterIntroPanel = new LeftHeaderProjectsCenterIntroPanel();
    private final AbstractGPanel rightHeaderProjectsCenterIntroPanel = new RightHeaderProjectsCenterIntroPanel();

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                leftHeaderProjectsCenterIntroPanel,
                rightHeaderProjectsCenterIntroPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(leftHeaderProjectsCenterIntroPanel, BorderLayout.WEST);
        this.add(rightHeaderProjectsCenterIntroPanel, BorderLayout.EAST);
    }
}

class LeftHeaderProjectsCenterIntroPanel extends AbstractGPanel{

    private final AbstractGTextField textField = new CustomTextField(ImageToolKit.getIcon("search@20x20"),40);
    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                textField
        );
    }

    @Override
    public void addComponents() {
        this.add(textField);
    }
}

class RightHeaderProjectsCenterIntroPanel extends AbstractGPanel{

    private AbstractGButton newButton = new SimpleGButton("New");
    private AbstractGButton openButton = new SimpleGButton("Open");
    private AbstractGButton vcsButton = new SimpleGButton("Get VCS");

    {
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                newButton,
                openButton,
                vcsButton
        );
    }

    @Override
    public void addComponents() {
        this.add(newButton);
        this.add(openButton);
        this.add(vcsButton);
    }
}

class BodyProjectsCenterIntroPanel extends AbstractGPanel{

    {
        this.setLayout(new BorderLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
