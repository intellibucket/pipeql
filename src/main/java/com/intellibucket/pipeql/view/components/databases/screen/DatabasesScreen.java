package com.intellibucket.pipeql.view.components.databases.screen;

import com.intellibucket.pipeql.eventlink.broker.concretes.DefaultEventLinkBroker;
import com.intellibucket.pipeql.eventlink.exception.DomainException;
import com.intellibucket.pipeql.eventlink.model.common.Topic;
import com.intellibucket.pipeql.eventlink.model.payload.EmptyPayload;
import com.intellibucket.pipeql.eventlink.model.payload.EmptySuccessPayload;
import com.intellibucket.pipeql.eventlink.model.payload.Payload;
import com.intellibucket.pipeql.eventlink.model.payload.SuccessPayload;
import com.intellibucket.pipeql.eventlink.rx.abstracts.Consumer;
import com.intellibucket.pipeql.lib.panel.ChangeablePanel;
import com.intellibucket.pipeql.lib.panel.MidGPanel;
import com.intellibucket.pipeql.lib.panel.side.SimpleSideGPanel;
import com.intellibucket.pipeql.view.components.ComponentInitializer;
import com.intellibucket.pipeql.view.components.databases.panel.BottomDatabasePanel;
import com.intellibucket.pipeql.view.components.databases.panel.LeftSideDatabasesPanel;
import com.intellibucket.pipeql.view.components.databases.panel.center.EmptyCenterDatabasesPanel;
import com.intellibucket.pipeql.view.topics.LeftMainPanelTopics;

import java.awt.*;
import java.util.List;

public class DatabasesScreen extends MidGPanel {

    //private final OpenDatabaseScreenListener openDatabaseScreenListener = new OpenDatabaseScreenListener();

    private final SimpleSideGPanel sidePanel;
    private final ChangeablePanel centerPanel;
    private final BottomDatabasePanel bottomPanel;

    public DatabasesScreen() {
        this.sidePanel = new LeftSideDatabasesPanel();
        this.centerPanel = new EmptyCenterDatabasesPanel();
        this.bottomPanel = new BottomDatabasePanel();
    }

    @Override
    public List<ComponentInitializer> getComponentInitializers() {
        return null;
    }

    @Override
    public void addComponents() {
        this.add(sidePanel, BorderLayout.WEST);
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }


//    class OpenDatabaseScreenListener extends Consumer<Payload, EmptySuccessPayload>{
//
//
//        @Override
//        protected EmptySuccessPayload fire(Payload message) throws DomainException {
//
//            return EmptySuccessPayload.INSTANCE;
//        }
//
//        @Override
//        protected List<Topic> mustBeRegistryTopics() {
//            return List.of(
//                    LeftMainPanelTopics.OPEN_DATABASE_SCREEN
//            );
//        }
//    }
}
