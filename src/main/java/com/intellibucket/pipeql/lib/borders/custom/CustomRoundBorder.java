package com.intellibucket.pipeql.lib.borders.custom;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.util.Optional;

public class CustomRoundBorder extends AbstractBorder {
    private static CustomRoundBorder INSTANCE;
    private final Color borderColor;

    private CustomRoundBorder(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        super.paintBorder(c, g, x, y, width, height);
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(borderColor);
        g2d.drawRoundRect(x, y, width - 1, height - 1, 10, 10); // Adjust the radius as needed
        g2d.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(5, 10, 5, 10);
    }

    @Override
    public Insets getBorderInsets(Component c, Insets insets) {
        insets.set(5, 10, 5, 10);
        return insets;
    }

    public static CustomRoundBorder getInstance(Color color){
        return Optional.ofNullable(INSTANCE).orElse(INSTANCE = new CustomRoundBorder(color));
    }
}
