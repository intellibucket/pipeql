package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure.center;

import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.util.List;

@Slf4j
public
class EmptyCenterStructurePanel extends AbstractGSimplePanel {

    private final AbstractGPanel labelBox = new EmptyCenterStructurePanel.LabelBox();

    {
        this.setLayout(new GridBagLayout());
    }

    @Override
    public java.util.List<ComponentInitializer> getComponentInitializers() {
        return java.util.List.of(
                this.labelBox
        );
    }

    @Override
    public void setComponents() {
        this.add(this.labelBox);
    }

    static class LabelBox extends AbstractGPanel {

        private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Search Table"), new BlueGLabel("Ctrl+Shift+T"));
        private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Chose and open table"), new BlueGLabel(""));

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        @Override
        public java.util.List<ComponentInitializer> getComponentInitializers() {
            return List.of(this.firstLine, this.secondLine);
        }

        @Override
        public void setComponents() {
            this.add(this.firstLine);
            this.add(this.secondLine);
        }
    }
}
