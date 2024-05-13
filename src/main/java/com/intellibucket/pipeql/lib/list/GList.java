package com.intellibucket.pipeql.lib.list;

import com.intellibucket.pipeql.lib.panel.GListItemPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.util.color.PaletteUtils;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    @Override
    public void setEventListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GList.this.setSelectedIndex(GList.this.locationToIndex(e.getPoint()));
            }
        });
    }

    static class PanelRenderer implements ListCellRenderer<GListItemPanel> {

        @Override
        public Component getListCellRendererComponent(JList<? extends GListItemPanel> list, GListItemPanel value, int index, boolean isSelected, boolean cellHasFocus) {
            value.setBackground(isSelected ? PaletteUtils.COLORFUL_BUTTON_BACKGROUND : list.getBackground());
            return value;
        }


    }
}
