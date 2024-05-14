package com.intellibucket.pipeql.lib.panel.layout;

import com.intellibucket.pipeql.lib.panel.TransparentGPanel;

import java.awt.*;

public abstract class BorderTransparentGPanel extends TransparentGPanel {

    {
        this.setLayout(new BorderLayout());
    }
}
