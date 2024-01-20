package com.intellibucket.pipeql.view.components;

import java.awt.*;

public enum Colors {
    NEW_PROJECT_TEXT_FIELD_MOUSE_ENTERED_COLOR{
        @Override
        public Color getColor() {
            return new Color(30, 144, 255);
        }
    },
    NEW_PROJECT_TEXT_FIELD_MOUSE_EXITED_COLOR{
        @Override
        public Color getColor() {
            return new Color(1, 11, 21);
        }
    };

    public abstract Color getColor();
}
