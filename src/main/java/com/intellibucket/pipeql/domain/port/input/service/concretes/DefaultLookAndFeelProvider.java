package com.intellibucket.pipeql.domain.port.input.service.concretes;

import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractLookAndFeelProvider;
import com.intellibucket.pipeql.lib.theme.GTheme;

import javax.swing.*;

public class DefaultLookAndFeelProvider extends AbstractLookAndFeelProvider {

    @Override
    public void initLookAndFeel() {
        try {
            UIManager.setLookAndFeel(GTheme.ARC_DARK_ORANGE.get());
        } catch (UnsupportedLookAndFeelException e) {
            JOptionPane.showMessageDialog(new JFrame("Error")," There was exception while initialize windows");
        }
    }


}
