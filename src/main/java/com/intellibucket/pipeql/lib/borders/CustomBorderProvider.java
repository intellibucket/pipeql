package com.intellibucket.pipeql.lib.borders;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public enum CustomBorderProvider {
    BOLD_BORDER {
        @Override
        public Border getBorder(Color color) {
            var roundedBorder = BorderFactory.createMatteBorder(1, 1, 1, 1, color);
            var emptyBorder = new EmptyBorder(5, 10, 5, 10);
            return new CompoundBorder(roundedBorder, emptyBorder);
        }
    },
    ONE_LINE_RIGHT_BORDER {
        @Override
        public Border getBorder(Color color) {
            return BorderFactory.createMatteBorder(0, 0, 0, 1, color);
        }
    };


    public abstract Border getBorder(Color color);
}
