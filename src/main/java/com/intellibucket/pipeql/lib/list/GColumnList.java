package com.intellibucket.pipeql.lib.list;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.GColumnListItemPanel;
import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.view.util.BorderUtils;
import com.intellibucket.pipeql.view.util.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public abstract class GColumnList  extends JList<GColumnListItemPanel> implements ComponentInitializer {

    protected final List<AbstractGSimplePanel> items;

    {
        this.setFixedCellHeight(20);
        this.setSelectedIndex(0);
        this.setBorder(BorderUtils.EMPTY_BORDER_5_5_5_5);
    }
    protected GColumnList(List<AbstractGSimplePanel> items) {
        super(new DefaultListModel<>());
        this.items = items;
        this.setCellRenderer(new PanelRenderer());
    }


    @Override
    public void setComponents() {
        this.setListData(items.toArray(new GColumnListItemPanel[this.items.size()]));
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return items.stream().map(item -> (ComponentInitializer) item).toList();
    }

    @Override
    public void setEventListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GColumnList.this.setSelectedIndex(GColumnList.this.locationToIndex(e.getPoint()));
            }
        });
    }

    static class PanelRenderer implements ListCellRenderer<GColumnListItemPanel> {

        @Override
        public Component getListCellRendererComponent(JList<? extends GColumnListItemPanel> list, GColumnListItemPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            value.setBackground(isSelected ? ColorUtils.COLORFUL_BUTTON_BACKGROUND : list.getBackground());
            return value;
        }


    }
}
