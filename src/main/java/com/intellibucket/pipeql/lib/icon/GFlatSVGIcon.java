package com.intellibucket.pipeql.lib.icon;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;

public class GFlatSVGIcon extends FlatSVGIcon {
    public GFlatSVGIcon(String name) {
        super(name);
    }

    public GFlatSVGIcon(String name, ClassLoader classLoader) {
        super(name, classLoader);
    }

    public GFlatSVGIcon(String name, int width, int height) {
        super(name, width, height);
    }

    public GFlatSVGIcon(String name, int width, int height, ClassLoader classLoader) {
        super(name, width, height, classLoader);
    }

    public GFlatSVGIcon(String name, float scale) {
        super(name, scale);
    }

    public GFlatSVGIcon(String name, float scale, ClassLoader classLoader) {
        super(name, scale, classLoader);
    }

    public GFlatSVGIcon(URL url) {
        super(url);
    }

    public GFlatSVGIcon(URI uri) {
        super(uri);
    }

    public GFlatSVGIcon(File file) {
        super(file);
    }

    public GFlatSVGIcon(InputStream in) throws IOException {
        super(in);
    }

    public GFlatSVGIcon(FlatSVGIcon icon) {
        super(icon);
    }

    protected GFlatSVGIcon(String name, int width, int height, float scale, boolean disabled, ClassLoader classLoader, URI uri) {
        super(name, width, height, scale, disabled, classLoader, uri);
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        super.paintIcon(c, g, x, y);
    }
}
