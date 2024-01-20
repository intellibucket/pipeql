package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.view.components.enums.CustomBorderProvider;
import com.intellibucket.pipeql.lib.customAdapters.MouseAdapterForTextField;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.CustomTextField;
import com.intellibucket.pipeql.view.components.enums.Colors;
import com.intellibucket.pipeql.view.components.ComponentInitializer;

import java.awt.*;
import java.util.List;

import static com.intellibucket.pipeql.view.components.enums.Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_ENTERED_COLOR;
import static com.intellibucket.pipeql.view.components.enums.Colors.NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR;

public class NewProjectLeftUpSideSearchPanel extends ChangeablePanel {

    private final AbstractGTextField textField = new CustomTextField(ImageToolKit.getIcon("search@20x20"), 20);
    private final AbstractGLabel iconPanel = new SimpleGLabel();

    {
        this.textField.setBorder(CustomBorderProvider.BOLD_BORDER.getBorder(Color.BLACK));

        this.textField.addMouseListener(new MouseAdapterForTextField(this.textField,
                CustomBorderProvider.BOLD_BORDER.getBorder(
                        Colors.getColor(NEW_PROJECT_TEXT_FIELD_MOUSE_ENTERED_COLOR)),
                CustomBorderProvider.BOLD_BORDER.getBorder(
                        Colors.getColor(NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR))));
        this.textField.setOpaque(false);

        this.setLayout(new BorderLayout());
        this.textField.setForeground(Color.GRAY);

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {

        return List.of(this.textField, this.iconPanel);
    }

    @Override
    public void addComponents() {
        this.add(this.iconPanel, BorderLayout.WEST);
        this.add(this.textField, BorderLayout.CENTER);

    }
}
