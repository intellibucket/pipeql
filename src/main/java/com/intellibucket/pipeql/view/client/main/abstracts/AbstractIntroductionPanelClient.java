package com.intellibucket.pipeql.view.client.main.abstracts;

import com.intellibucket.pipeql.eventlink.rx.abstracts.Callback;
import com.intellibucket.pipeql.lib.frame.abstracts.AbstractGFrame;
import com.intellibucket.pipeql.lib.panel.AbstractGPanel;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.textField.AbstractGTextField;
import com.intellibucket.pipeql.lib.textField.SimpleGTextField;

public interface AbstractIntroductionPanelClient {
    void newProject(AbstractGPanel abstractGPanel);
    void selectDirectory(ChangeablePanel changeablePanel, AbstractGTextField textField);

}
