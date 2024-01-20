package com.intellibucket.pipeql.lib.customAdapters;

import com.intellibucket.pipeql.lib.textField.AbstractGTextField;

import javax.swing.border.Border;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseAdapterForTextField extends MouseAdapter {

    private final AbstractGTextField textField;
    private final Border borderEntered;
    private final Border borderExited;

    public MouseAdapterForTextField(AbstractGTextField abstractGTextField,
                                    Border borderEntered,
                                    Border borderExited) {
        this.textField = abstractGTextField;
        this.borderEntered = borderEntered;
        this.borderExited = borderExited;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        textField.setBorder(borderEntered);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        textField.setBorder(borderExited);
    }

}
