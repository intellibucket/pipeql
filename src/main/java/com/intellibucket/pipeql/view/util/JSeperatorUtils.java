package com.intellibucket.pipeql.view.util;

import javax.swing.*;

public class JSeperatorUtils {
    public static JSeparator getHorizontalSeparator() {
        var sep = new JSeparator(SwingConstants.HORIZONTAL);
        sep.setForeground(ColorUtils.LIGHT_GRAY_7X);
        return sep;
    }
}
