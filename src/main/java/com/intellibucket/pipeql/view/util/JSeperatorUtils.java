package com.intellibucket.pipeql.view.util;

import com.intellibucket.pipeql.view.util.color.PaletteUtils;

import javax.swing.*;

public class JSeperatorUtils {
    public static JSeparator getHorizontalSeparator() {
        var sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setForeground(PaletteUtils.LIGHT_GRAY_7X);
        return sep;
    }
}
