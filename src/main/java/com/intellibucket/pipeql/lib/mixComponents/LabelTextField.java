package com.intellibucket.pipeql.lib.mixComponents;

import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;
@Getter
public class LabelTextField extends ChangeablePanel {
    private final AbstractGLabel label = new SimpleGLabel();
    private final AbstractGTextField textField = new SimpleGTextField();

    {
        setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
        this.textField.setMaximumSize(new Dimension(250, this.textField.getPreferredSize().height));
        this.setAlignmentX(Component.LEFT_ALIGNMENT);

    }

    public LabelTextField(String labelText, String textFieldText) {

        label.setText(labelText);
        textField.setText(textFieldText);


    }

    public LabelTextField(String labelText) {

        label.setText(labelText);


    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.label, this.textField);
    }

    @Override
    public void addComponents() {
        this.add(label);
        this.add(textField);
    }


}
