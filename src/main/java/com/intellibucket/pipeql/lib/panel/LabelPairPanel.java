package com.intellibucket.pipeql.lib.panel;

import com.intellibucket.pipeql.lib.file.ImageContainer;
import com.intellibucket.pipeql.lib.file.ImageToolKit;
import com.intellibucket.pipeql.lib.label.AbstractGLabel;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.lib.label.SimpleGLabel;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LabelPairPanel extends AbstractGPanel{

    private final AbstractGLabel firstLabel;
    private final AbstractGLabel secondLabel;

    {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public LabelPairPanel(AbstractGLabel firstLabel, AbstractGLabel secondLabel) {
        this.firstLabel = firstLabel;
        this.secondLabel = secondLabel;
    }


    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(
                this.firstLabel,
                this.secondLabel
        );
    }

    @Override
    public void setComponents() {
        this.add(this.firstLabel);
        this.add(Box.createRigidArea(new Dimension(5,0)));
        this.add(this.secondLabel);
    }

    public static class Prototype{
        public static LabelPairPanel success(String text){
            return new LabelPairPanel(new SimpleGLabel(ImageToolKit.getSmallIcon("successDialog")), new SimpleGLabel(text));
        }

        public static LabelPairPanel error(String text){
            return new LabelPairPanel(new SimpleGLabel(ImageToolKit.getSmallIcon("errorDialog")), new SimpleGLabel(text));
        }

        public static LabelPairPanel info(String text){
            return new LabelPairPanel(new SimpleGLabel(ImageToolKit.getSmallIcon("informationDialog")), new SimpleGLabel(text));
        }

        public static LabelPairPanel warning(String text){
            return new LabelPairPanel(new SimpleGLabel(ImageToolKit.getSmallIcon("warningDialog")), new SimpleGLabel(text));
        }
    }
}
