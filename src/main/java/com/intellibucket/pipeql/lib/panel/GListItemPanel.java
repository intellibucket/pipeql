package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.button.horizontal.AbstractGButton;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;
import com.intellibucket.pipeql.view.util.BordersUtil;
import com.intellibucket.pipeql.view.util.FontsUtil;
import com.intellibucket.pipeql.view.util.IconUtils;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

@Slf4j
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
    public String toString() {
        return item.schema() + "." + item.name();
    }


    @Override
    public void setEventPublisher() {
        log.info("Setting event publisher for: {}", this);
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                log.info("Clicked: {}", GListItemPanel.this);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                log.info("Pressed: {}", GListItemPanel.this);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                log.info("Released: {}", GListItemPanel.this);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                log.info("Entered: {}", GListItemPanel.this);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                log.info("Exited: {}", GListItemPanel.this);
            }
        });
    }

    @Override
    public void setEventListener() {

    }


}
