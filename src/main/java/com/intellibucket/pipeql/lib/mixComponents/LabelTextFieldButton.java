package com.intellibucket.pipeql.lib.mixComponents;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import lombok.Getter;

import javax.swing.*;
import java.util.List;
@Getter
public class LabelTextFieldButton extends LabelTextField {
    private final SimpleGButton button;

    public LabelTextFieldButton(String labelText, String textFieldText, String buttonName, Icon buttonIcon) {
        super(labelText, textFieldText);
        this.button = new SimpleGButton(buttonName, buttonIcon);
    }

    public LabelTextFieldButton(String labelText, String buttonName, Icon buttonIcon) {
        super(labelText);
        this.button = new SimpleGButton(buttonName, buttonIcon);
    }

    public LabelTextFieldButton(String labelText,  Icon buttonIcon) {
        super(labelText);
        this.button = new SimpleGButton(null, buttonIcon);
    }

    public AbstractGButton getButton() {
        return this.button;
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(super.getLabel(), super.getTextField(), this.button);
    }

    @Override
    public void addComponents() {
        this.add(super.getLabel());
        this.add(super.getTextField());
        this.add(this.button);
    }



}
