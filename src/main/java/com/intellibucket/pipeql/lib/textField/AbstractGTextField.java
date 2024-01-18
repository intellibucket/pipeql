package com.intellibucket.pipeql.lib.textField;

import com.intellibucket.pipeql.view.components.ComponentInitializer;

import javax.swing.*;
import javax.swing.text.Document;

public abstract class AbstractGTextField  extends JTextField implements ComponentInitializer {
    public AbstractGTextField() {
    }

    public AbstractGTextField(String text) {
        super(text);
    }

    public AbstractGTextField(int columns) {
        super(columns);
    }

    public AbstractGTextField(String text, int columns) {
        super(text, columns);
    }

    public AbstractGTextField(Document doc, String text, int columns) {
        super(doc, text, columns);
    }
}
