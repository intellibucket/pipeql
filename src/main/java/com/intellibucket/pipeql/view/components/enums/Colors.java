package com.intellibucket.pipeql.view.components.enums;

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
    },
    NEW_PROJECT_CREATE_BUTTON_BACKGROUND_COLOR{
        @Override
        public Color getColor() {
            return new Color(11, 148, 217);
        }
    },
    NEW_PROJECT_CREATE_BUTTON_MOUSE_ENTERED_COLOR{
        @Override
        public Color getColor() {
            return new Color(227, 13, 120);
        }
    },
    ;

    protected abstract Color getColor();

    public static Color getColor(Colors colors){
        return colors.getColor();
    }

}
