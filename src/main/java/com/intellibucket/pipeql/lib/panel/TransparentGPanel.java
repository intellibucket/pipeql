package com.intellibucket.pipeql.lib.panel;

import java.awt.*;

public abstract class TransparentGPanel extends AbstractGPanel{
    {
        this.setOpaque(false);
        this.setBackground(new Color(0,0,0,0));
    }
}
