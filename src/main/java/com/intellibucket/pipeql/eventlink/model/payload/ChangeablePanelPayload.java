package com.intellibucket.pipeql.eventlink.model.payload;

import com.intellibucket.pipeql.lib.panel.ChangeablePanel;

public class ChangeablePanelPayload implements Payload{
    private final ChangeablePanel changeablePanel;

    public ChangeablePanelPayload(ChangeablePanel changeablePanel) {
        this.changeablePanel = changeablePanel;
    }

    public ChangeablePanel getChangeablePanel() {
        return changeablePanel;
    }
}
