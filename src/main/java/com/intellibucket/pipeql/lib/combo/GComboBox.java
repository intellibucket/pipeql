package com.intellibucket.pipeql.lib.combo;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure.LeftSideStructurePanel;
import com.intellibucket.pipeql.view.util.ColorsUtil;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;

public abstract class GComboBox extends JComboBox<GComboBoxItem> implements ComponentInitializer {



    public GComboBox(DefaultComboBoxModel<com.intellibucket.pipeql.lib.combo.GComboBoxItem> model) {
        super(model);
    }
    public GComboBox(com.intellibucket.pipeql.lib.combo.GComboBoxItem[] items) {
        super();
        this.setEditable(false);
        this.setLightWeightPopupEnabled(true);
        this.setRenderer(new PanelRenderer());
    }

    public GComboBox(List<GComboBoxItem> items) {
        this(items.toArray((GComboBoxItem[]) new AbstractGPanel[0]));
    }


    @Override
    public void addComponents() {

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }
    static class PanelRenderer implements ListCellRenderer<GComboBoxItem> {

    @Override
    public Component getListCellRendererComponent(JList<? extends GComboBoxItem> list, GComboBoxItem value, int index, boolean isSelected, boolean cellHasFocus) {
        value.setBackground(isSelected ? ColorsUtil.COLORFUL_BUTTON_BACKGROUND : list.getBackground());
        return value;
    }
}
}
