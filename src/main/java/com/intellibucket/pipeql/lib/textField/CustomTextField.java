package com.intellibucket.pipeql.lib.textField;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Getter
public class CustomTextField extends AbstractGTextField {
    private final static int DEFAULT_COLUMNS = 25;
    private AbstractGButton button = new SimpleGButton();

    public CustomTextField(Icon icon, int columns) {
        super(columns);
        init(icon);
    }

    public CustomTextField() {

    }

    public CustomTextField(Icon icon) {
        super(DEFAULT_COLUMNS);
        init(icon);
    }

    public CustomTextField(String textField) {
        super(textField);

    }

    public CustomTextField(int columns) {
        super(columns);

    }



    private void init(Icon icon) {
        button = new SimpleGButton(icon);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        setLayout(new BorderLayout());
        add(button, BorderLayout.EAST);

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.TEXT_CURSOR));
            }
        });




    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }

}
