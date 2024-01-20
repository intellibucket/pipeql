package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;

public interface AbstractIntroductionPanelClient {
    void newProject(AbstractGPanel abstractGPanel);
    void selectDirectory(AbstractGSimplePanel changeablePanel, AbstractGTextField textField);

}
