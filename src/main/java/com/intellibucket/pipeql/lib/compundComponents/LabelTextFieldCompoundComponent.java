package com.intellibucket.pipeql.lib.compundComponents;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.textField.CustomTextField;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Getter
public class LabelTextFieldCompoundComponent extends AbstractCompoundComponent {
    private final AbstractGLabel label;
    private final CustomTextField textField;

    public LabelTextFieldCompoundComponent(String labelText, String textFieldText) {
        this.label = new SimpleGLabel(labelText);
        this.textField = new CustomTextField(textFieldText);

    }


    public LabelTextFieldCompoundComponent(String labelText) {
        this.label = new SimpleGLabel(labelText);
        this.textField = new CustomTextField();

    }

    public LabelTextFieldCompoundComponent(String labelText, Icon buttonIcon) {
        this.label = new SimpleGLabel(labelText);
        this.textField = new CustomTextField(buttonIcon);

    }

    public LabelTextFieldCompoundComponent(String labelText, Icon buttonIcon, int textFieldColumns) {
        this.label = new SimpleGLabel(labelText);
        this.textField = new CustomTextField(buttonIcon, textFieldColumns);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.label, this.textField);
    }

    @Override
    public void addComponents() {
        textField.setColumns(25);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(textField, gbc);
    }
}
