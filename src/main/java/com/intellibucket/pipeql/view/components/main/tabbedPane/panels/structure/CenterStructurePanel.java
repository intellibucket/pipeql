package com.intellibucket.pipeql.view.components.main.tabbedPane.panels.structure;

import com.intellibucket.pipeql.lib.label.BigInfoGLabel;
import com.intellibucket.pipeql.lib.label.BlueGLabel;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.panel.LabelPairPanel;
import com.intellibucket.pipeql.lib.panel.TransparentGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.main.model.TableItemModel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class CenterStructurePanel extends AbstractGSimplePanel {

    private final AbstractGSimplePanel mainPanel;

    {
        this.setLayout(new BorderLayout());
    }
    public CenterStructurePanel() {
        this.mainPanel = new EmptyCenterStructurePanel();
    }

    public CenterStructurePanel(AbstractGSimplePanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.mainPanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.mainPanel, BorderLayout.CENTER);
    }
}


class EmptyCenterStructurePanel extends AbstractGSimplePanel {

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
    public void addComponents() {
        this.add(this.labelBox);
    }

    static class LabelBox extends AbstractGPanel {

        private final AbstractGPanel firstLine = new LabelPairPanel(new BigInfoGLabel("Search Table"),new BlueGLabel("Ctrl+Shift+T"));
        private final AbstractGPanel secondLine = new LabelPairPanel(new BigInfoGLabel("Chose and open table"),new BlueGLabel(""));

        {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        }

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of(this.firstLine,this.secondLine);
        }

        @Override
        public void addComponents() {
            this.add(this.firstLine);
            this.add(this.secondLine);
        }
    }
}

class TableCenterStructurePanel extends AbstractGSimplePanel {
    {
        this.setLayout(new BorderLayout());
    }

    private final TableItemModel tableItemModel;
    private final HeaderOfTableCenterStructurePanel headerOfTableCenterStructurePanel;
    private final CenterOfTableCenterStructurePanel centerOfTableCenterStructurePanel;

    public TableCenterStructurePanel(TableItemModel tableItemModel) {
        this.tableItemModel = tableItemModel;
        this.headerOfTableCenterStructurePanel = new HeaderOfTableCenterStructurePanel();
        this.centerOfTableCenterStructurePanel = new CenterOfTableCenterStructurePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.headerOfTableCenterStructurePanel
        );
    }

    @Override
    public void addComponents() {
        this.add(this.headerOfTableCenterStructurePanel, BorderLayout.NORTH);
    }

    class HeaderOfTableCenterStructurePanel extends TransparentGPanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void addComponents() {

        }
    }

    class CenterOfTableCenterStructurePanel extends TransparentGPanel{

        @Override
        public List<ComponentInitializer> getComponentInitializers() {
            return List.of();
        }

        @Override
        public void addComponents() {

        }
    }




}