package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class ImageGPanel extends AbstractGPanel{
    private Image image;

    public ImageGPanel(Image image) {
        this.image = image;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
