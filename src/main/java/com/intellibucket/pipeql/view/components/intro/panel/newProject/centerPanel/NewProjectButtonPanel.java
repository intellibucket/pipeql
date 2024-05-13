package com.intellibucket.pipeql.view.components.intro.panel.newProject.centerPanel;

import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.lib.button.custom.BeautifulButton;
import com.intellibucket.pipeql.lib.panel.AbstractGSimplePanel;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractIntroductionPanelClient;
import com.intellibucket.pipeql.view.actions.main.concretes.IntroductionPanelClient;
import com.intellibucket.pipeql.lib.ComponentInitializer;
import com.intellibucket.pipeql.view.components.enums.Colors;
import com.intellibucket.pipeql.view.topics.NewProjectPanelTopics;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.util.List;

import static com.intellibucket.pipeql.view.components.enums.Colors.NEW_PROJECT_CREATE_BUTTON_BACKGROUND_COLOR;
import static com.intellibucket.pipeql.view.components.enums.Colors.NEW_PROJECT_CREATE_BUTTON_MOUSE_ENTERED_COLOR;

@Slf4j
public class NewProjectButtonPanel extends AbstractGSimplePanel {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;
    private final AbstractIntroductionPanelClient client;


    private final BeautifulButton createButton;
    private final BeautifulButton cancelButton;




    {
        setLayout(new GridBagLayout());
        this.createButton = new BeautifulButton(
                "Create",
                Color.WHITE,
                Colors.getColor(NEW_PROJECT_CREATE_BUTTON_BACKGROUND_COLOR),
                Colors.getColor(NEW_PROJECT_CREATE_BUTTON_MOUSE_ENTERED_COLOR));
        this.cancelButton = new BeautifulButton("Cancel",
                Color.WHITE,
                Colors.getColor(NEW_PROJECT_CREATE_BUTTON_BACKGROUND_COLOR),
                Colors.getColor(NEW_PROJECT_CREATE_BUTTON_BACKGROUND_COLOR));
        this.client = new IntroductionPanelClient();

    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return List.of(createButton, cancelButton);
    }

    @Override
    public void setComponents() {
        var gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 0, 20);
        add(createButton, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 20, 0, 0);
        add(cancelButton, gbc);

    }

    @Override
    public void setEventPublisher() {
        this.createButton.addActionListener(e -> {
                    log.info("NewProjectCreateAndCancelButtonPanel.createNewProject");
                    var message = ProducingMessage.Builder
                            .builder()
                            .topic(NewProjectPanelTopics.CLICKED_CREATE_NEW_PROJECT)
                            .event(new StartEvent<>("Create"))
                            .build();
                    eventLinkTemplate.publish(message);
                }
        );

        this.cancelButton.addActionListener(e -> {
                    log.info("NewProjectCreateAndCancelButtonPanel.cancelNewProject");
                    var message = ProducingMessage.Builder
                            .builder()
                            .topic(NewProjectPanelTopics.CLICKED_CANCEL_NEW_PROJECT)
                            .event(new StartEvent<>("Start"))
                            .build();
                    eventLinkTemplate.publish(message);
                }
        );
    }
}
