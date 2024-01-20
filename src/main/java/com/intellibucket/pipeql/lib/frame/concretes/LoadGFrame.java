package com.intellibucket.pipeql.lib.frame.concretes;

import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public abstract class LoadGFrame extends AbstractGFrame {


    {
        this.setMinimumSize(new Dimension(800, 400));
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setShape(new RoundRectangle2D.Double(0, 0, this.getWidth(), this.getHeight(), 50, 50));
    }

    public LoadGFrame() {
    }

    public abstract void incrementProgress();


}
