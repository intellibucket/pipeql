package com.intellibucket.pipeql.view.components.main.panel.main.center.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.domain.model.dto.response.ProjectModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RightSideStructurePanel extends AbstractGSimplePanel {

    private final AbstractGSimplePanel mainPanel;

    {
        this.setLayout(new BorderLayout());
    }

    public RightSideStructurePanel() {
        this.mainPanel = new EmptyRightSideStructurePanel();
    }

    public RightSideStructurePanel(ProjectModel projectModel) {
        //TODO: change this
        this.mainPanel = new EmptyRightSideStructurePanel();
    }
    public RightSideStructurePanel(AbstractGSimplePanel panel) {
        this.mainPanel = panel;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainPanel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.mainPanel, BorderLayout.CENTER);
    }

}

class EmptyRightSideStructurePanel extends AbstractGSimplePanel {

    private final AbstractGPanel labelBox = new LabelBox();

    {
        this.setLayout(new GridBagLayout());
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.labelBox
        );
    }

    @Override
    public void setComponents() {
        this.add(this.labelBox);
    }

    static class LabelBox extends AbstractGPanel {
        private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Double click colum for open panel"),new BlueGLabel(""));

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(this.secondLine);
        }

        @Override
        public void setComponents() {
            this.add(this.secondLine);
        }
    }
}
class ColumnSettingsPanel extends AbstractGSimplePanel {

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of();
    }

    @Override
    public void setComponents() {

    }

}

