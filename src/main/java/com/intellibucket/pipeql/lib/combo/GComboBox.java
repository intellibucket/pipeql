package com.intellibucket.pipeql.lib.combo;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.ColorUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public abstract class GComboBox extends JComboBox<GComboBoxItem> implements ComponentInitializer {


    public GComboBox(DefaultComboBoxModel<com.intellibucket.pipeql.lib.combo.GComboBoxItem> model) {
        super(model);
    }

    public GComboBox(GComboBoxItem[] items) {
        super();
        this.setEditable(false);
        this.setLightWeightPopupEnabled(true);
        this.setRenderer(new PanelRenderer());
    }

    public GComboBox(List<GComboBoxItem> items) {
        this(items.toArray((GComboBoxItem[]) new AbstractGPanel[0]));
    }


    @Override
    public void setComponents() {

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }


    @Override
    public void setAction(Action a) {

    }

    static class PanelRenderer implements ListCellRenderer<GComboBoxItem> {

        @Override
        public Component getListCellRendererComponent(JList<? extends GComboBoxItem> list, GComboBoxItem value, int index, boolean isSelected, boolean cellHasFocus) {
            value.setBackground(isSelected ? ColorUtils.COLORFUL_BUTTON_BACKGROUND : list.getBackground());
            return value;
        }
    }
}
