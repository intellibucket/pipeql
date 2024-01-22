package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.button.horizontal.SimpleIconGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;
import com.intellibucket.pipeql.view.util.BordersUtil;
import com.intellibucket.pipeql.view.util.FontsUtil;

import java.awt.*;
import java.util.List;

public class GListItemPanel extends AbstractGPanel{
    private final TableItemModel item;
    private final AbstractGLabel picLabel;
    private final AbstractGLabel label;
    private final AbstractGButton dropButton = new SimpleIconGButton("editorPreview");

    {
        this.setLayout(new BorderLayout());
    }
    public GListItemPanel(TableItemModel item) {
        this.item = item;
        this.picLabel = new SimpleGLabel(ImageToolKit.getIcon("DataTables"));
        this.label = new SimpleGLabel(item.name(), FontsUtil.HELVETICA_PLAIN_12);
        this.label.setBorder(BordersUtil.EMPTY_BORDER_0_5_0_0);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.picLabel,this.label, this.dropButton);
    }

    @Override
    public void addComponents() {
        this.add(this.picLabel, BorderLayout.WEST);
        this.add(this.label, BorderLayout.CENTER);
        this.add(this.dropButton, BorderLayout.EAST);
    }

    @Override
    public String toString() {
        return item.schema() + "." + item.name();
    }
}
