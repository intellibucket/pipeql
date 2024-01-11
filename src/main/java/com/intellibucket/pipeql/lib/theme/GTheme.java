package com.intellibucket.pipeql.lib.theme;

import com.formdev.flatlaf.intellijthemes.FlatArcIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCarbonIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.*;

import javax.swing.*;

public enum GTheme
    {
        DRACULA{
        @Override
        public LookAndFeel get() {
            return new FlatDraculaIJTheme();
        }
    }
    ,LIGHT{
        @Override
        public LookAndFeel get() {
            return new FlatLightOwlIJTheme();
        }
    },ARC_DARK{
        @Override
        public LookAndFeel get() {
            return new FlatArcDarkContrastIJTheme();
        }
    },ARC{
        @Override
        public LookAndFeel get() {
            return new FlatArcIJTheme();
        }
    },
        CARBON{
        @Override
        public LookAndFeel get() {
            return new FlatCarbonIJTheme();
        }
    },
        GITHUB_DARK_CONTRAST{
        @Override
        public LookAndFeel get() {
            return new FlatGitHubDarkContrastIJTheme();
        }
    },
        ATOM_DARK_CONTRAST{
        @Override
        public LookAndFeel get() {
            return new FlatAtomOneDarkContrastIJTheme();
        }
    },
        ATOM_LIGHT_CONTRAST{
        @Override
        public LookAndFeel get() {
            return new FlatAtomOneLightContrastIJTheme();
        }
    },
        ARC_DARK_ORANGE{
        @Override
        public LookAndFeel get() {
            return new FlatArcDarkIJTheme();
        }
    };

        public abstract LookAndFeel get();
}
