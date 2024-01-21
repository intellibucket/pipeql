package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.view.util.ColorsUtil;

import java.awt.*;

public abstract class ButtonGPanel extends AbstractGPanel{
    private Color background;
    private Color foreground;

    {
        this.background = this.getBackground();
        this.foreground = this.getForeground();
        this.addMouseListener(new java.awt.event.MouseAdapter() {
                @Override
                public void mouseEntered(java.awt.event.MouseEvent evt) {
                    setBackground(ColorsUtil.COLORFUL_BUTTON_BACKGROUND);
                    setForeground(ColorsUtil.COLORFUL_BUTTON_TEXT_COLOR);
                }

                @Override
                public void mouseExited(java.awt.event.MouseEvent evt) {
                    setBackground(ButtonGPanel.this.background);
                    setForeground(ButtonGPanel.this.foreground);
                }
            }
        );

    }
}
