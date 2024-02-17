package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;
import com.intellibucket.pipeql.view.util.BorderUtils;

import java.awt.*;
import java.util.List;

public abstract class GItemTextFieldPanel extends TransparentGPanel{
    private final SimpleGLabel label;
    private final SimpleGTextField textField = new SimpleGTextField();

    {
        this.setLayout(new GridLayout(2, 1));
        this.setBorder(BorderUtils.EMPTY_BORDER_5_5_5_5);
    }

    public GItemTextFieldPanel(String itemName) {
        this.label = new SimpleGLabel(itemName);
    }

    public GItemTextFieldPanel(String itemName, String text) {
        this.label = new SimpleGLabel(itemName);
        this.textField.setText(text);
    }

    public SimpleGTextField getTextField() {
        return this.textField;
    }

    @Override
    public void setComponents() {
        this.label.setAlignmentX(LEFT_ALIGNMENT);
        this.textField.setAlignmentX(CENTER_ALIGNMENT);
        this.add(this.label);
        this.add(this.textField);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.label,
                this.textField
        );
    }

}
