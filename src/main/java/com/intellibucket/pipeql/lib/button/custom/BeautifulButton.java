package com.intellibucket.pipeql.lib.button.custom;

import com.intellibucket.pipeql.lib.button.horizontal.SimpleGButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BeautifulButton extends SimpleGButton {

    public BeautifulButton(String text, Color foregroundColor, Color backGroundColor, Color mouseEnteredColor) {
        super(text);
        setContentAreaFilled(true);
        setFocusPainted(true);
        setBorderPainted(false);
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder(3, 15, 3, 15));

        setBackground(backGroundColor);
        setForeground(foregroundColor);
        setFont(new Font("Arial", Font.PLAIN, 14));

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(foregroundColor);
                setForeground(backGroundColor);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(backGroundColor);
                setForeground(foregroundColor);
            }
        });

        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(getBackground());
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);

        super.paintComponent(g2d);

        g2d.dispose();
    }
}