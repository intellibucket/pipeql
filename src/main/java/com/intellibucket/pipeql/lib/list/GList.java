package com.intellibucket.pipeql.lib.list;

import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.scrollpane.GScrollPane;
import com.intellibucket.pipeql.view.util.ColorUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public abstract class GList extends JList<GListItemPanel> implements ComponentInitializer {
    protected final List<GListItemPanel > items;

    {
        this.setFixedCellHeight(20);
        this.setSelectedIndex(-1);
    }
    protected GList(List<GListItemPanel> items) {
        super(new DefaultListModel<>());
        this.items = items;
        this.setCellRenderer(new PanelRenderer());
    }


    @Override
    public void setComponents() {
        this.setListData(items.toArray(new GListItemPanel[this.items.size()]));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return items.stream().map(item -> (ComponentInitializer) item).toList();
    }


    static class PanelRenderer implements ListCellRenderer<GListItemPanel> {

        @Override
        public Component getListCellRendererComponent(JList<? extends GListItemPanel> list, GListItemPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            value.setBackground(isSelected ? ColorUtils.COLORFUL_BUTTON_BACKGROUND : list.getBackground());
            return value;
        }


    }
}
