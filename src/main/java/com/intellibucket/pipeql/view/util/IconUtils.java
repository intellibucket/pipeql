package com.intellibucket.pipeql.view.util;

import com.intellibucket.pipeql.lib.button.BorderlessIconGButton;
import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;

public class IconUtils {
    public static AbstractGButton success() {
        return new BorderlessIconGButton("inspectionsOK");
    }

    public static AbstractGButton fail() {
        return new BorderlessIconGButton("red");
    }
}
