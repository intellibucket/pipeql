package com.intellibucket.pipeql.view.components.intro.screens;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.basic.BasicSplitPaneDivider;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

 class CustomSplitPaneDividerExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Split Pane Divider");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            JPanel leftPanel = new JPanel();
            leftPanel.setBackground(Color.RED);

            JPanel rightPanel = new JPanel();
            rightPanel.setBackground(Color.BLUE);

            JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);

            // Set custom UI for JSplitPane
            splitPane.setUI(new BasicSplitPaneUI() {
                @Override
                public BasicSplitPaneDivider createDefaultDivider() {
                    return new BasicSplitPaneDivider(this) {
                        @Override
                        public void setBorder(Border b) {
                            // Override setBorder to remove the border
                        }

                        @Override
                        public void paint(Graphics g) {
                            super.paint(g);
                        }
                    };
                }
            });

            frame.add(splitPane);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
