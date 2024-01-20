package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class ImageGPanel extends TransparentGPanel{
    private final Image image;

    public ImageGPanel(Image image) {
        this.image = image;
        loadImage();
    }


    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.image, 0, 0, this.getWidth(), this.getHeight(), this);
    }

    private void loadImage() {
        try {

            var mediaTracker = new MediaTracker(this);
            mediaTracker.addImage(image, 0);
            mediaTracker.waitForID(0);
            if (mediaTracker.isErrorID(0)) {
                System.err.println("Error loading image");
            } else {
                setPreferredSize(new Dimension(image.getWidth(this), image.getHeight(this)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
