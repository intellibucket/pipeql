package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class ImageGPanel extends AbstractGPanel{
    private Image image;

    public ImageGPanel(String imagePath) {
        loadImage(imagePath);
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private void loadImage(String imagePath) {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            image = toolkit.getImage(getClass().getClassLoader().getResource(imagePath));

            MediaTracker mediaTracker = new MediaTracker(this);
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            if (mediaTracker.isErrorID(0)) {
                System.err.println("Error loading image: " + imagePath);
            } else {
                setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
