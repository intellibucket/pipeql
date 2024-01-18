package com.intellibucket.pipeql.lib.textField;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.text.Document;
import java.util.List;

public class SimpleGTextField extends AbstractGTextField {
    public SimpleGTextField() {
    }

    public SimpleGTextField(String text) {
        super(text);
    }

    public SimpleGTextField(int columns) {
        super(columns);
    }

    public SimpleGTextField(String text, int columns) {
        super(text, columns);
    }

    public SimpleGTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void addComponents() {

    }
}
