package com.intellibucket.pipeql.view.components.intro.panel.newProject;

import com.intellibucket.pipeql.lib.label.ErrorGTextField;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.ComponentInitializer;

import java.util.List;

public class ExceptionPanel extends SimpleSideGPanel {
    private final AbstractGTextField infoGTextField = new ErrorGTextField(null);


    public void message(String text){
        this.infoGTextField.setText(text);
        this.infoGTextField.setVisible(true);
        this.setVisible(true);
    }

    public void close(){
        this.infoGTextField.setVisible(false);
        this.setVisible(false);
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(infoGTextField);
    }

    @Override
    public void setComponents() {
        this.add(this.infoGTextField);

    }
}
