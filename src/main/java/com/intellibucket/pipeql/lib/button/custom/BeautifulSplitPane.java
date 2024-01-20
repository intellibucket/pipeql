package com.intellibucket.pipeql.lib.button.custom;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

public class BeautifulSplitPane extends JSplitPane {
    private  Border border;
    public BeautifulSplitPane() {
    }



    public BeautifulSplitPane(int newOrientation) {
        super(newOrientation);
    }

    public BeautifulSplitPane(int newOrientation, boolean newContinuousLayout) {
        super(newOrientation, newContinuousLayout);
    }

    public BeautifulSplitPane(int newOrientation, Component newLeftComponent, Component newRightComponent, Border border) {
        super(newOrientation, newLeftComponent, newRightComponent);
        this.border = border;
        setUi();

    }

    public BeautifulSplitPane(int newOrientation, boolean newContinuousLayout, Component newLeftComponent, Component newRightComponent) {
        super(newOrientation, newContinuousLayout, newLeftComponent, newRightComponent);
    }

    void setUi(){
        this.setUI(new BasicSplitPaneUI() {
        @Override
        public BasicSplitPaneDivider createDefaultDivider() {
            return new BasicSplitPaneDivider(this) {
                @Override
                public void setBorder(Border b) {
                    super.setBorder(BeautifulSplitPane.this.border);
                }

                @Override
                public void paint(Graphics g) {
                    super.paint(g);

                    // Draw a straight line as a custom divider
                    g.setColor(Color.BLACK);
                    int dividerLoc = getLocation().x + getSize().width / 2;
                    g.fillRect(dividerLoc - 1, getLocation().y, 2, getSize().height);
                }
            };
        }
    });}




}
