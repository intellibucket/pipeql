package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.domain.model.dto.response.TableItemModel;
import com.intellibucket.pipeql.view.util.BordersUtil;
import com.intellibucket.pipeql.view.util.FontsUtil;
import com.intellibucket.pipeql.view.util.IconUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

@Slf4j
@Getter
public class GListItemPanel extends AbstractGPanel{
    private final TableItemModel item;
    private final AbstractGLabel picLabel;
    private final AbstractGLabel label;
    private final AbstractGButton dropButton;

    {
        this.setLayout(new BorderLayout());
    }
    public GListItemPanel(TableItemModel item) {
        this.item = item;
        this.picLabel = new SimpleGLabel(ImageToolKit.getIcon("DataTables"));
        this.label = new SimpleGLabel(item.name(), FontsUtil.HELVETICA_PLAIN_12);
        this.dropButton = item.isValid() ? IconUtils.success() : IconUtils.fail();
        this.label.setBorder(BordersUtil.EMPTY_BORDER_0_5_0_0);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(this.picLabel,this.label, this.dropButton);
    }

    @Override
    public void setComponents() {
        this.add(this.picLabel, BorderLayout.WEST);
        this.add(this.label, BorderLayout.CENTER);
        this.add(this.dropButton, BorderLayout.EAST);
    }

    @Override
    public void setEventPublisher() {

    }

    @Override
    public void setEventListener() {

    }

    @Override
    public String toString() {
        return item.schema() + "." + item.name();
    }



}
