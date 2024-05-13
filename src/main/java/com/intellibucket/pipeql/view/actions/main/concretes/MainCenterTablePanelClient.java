package com.intellibucket.pipeql.view.actions.main.concretes;

import com.intellibucket.pipeql.domain.model.valueo.TableID;
import com.intellibucket.pipeql.domain.port.input.service.abstracts.AbstractTableDetailService;
import com.intellibucket.pipeql.domain.port.input.service.factory.DetailServiceFactory;
import com.intellibucket.pipeql.eventlink.model.event.concretes.FailureEvent;
import com.intellibucket.pipeql.eventlink.model.event.concretes.start.StartEvent;
import com.intellibucket.pipeql.eventlink.model.producer.ProducingMessage;
import com.intellibucket.pipeql.eventlink.rx.abstracts.OnlyFailCallback;
import com.intellibucket.pipeql.eventlink.template.abstracts.EventLinkTemplate;
import com.intellibucket.pipeql.view.actions.main.abstracts.AbstractMainCenterTablePanelClient;
import com.intellibucket.pipeql.view.actions.payloads.TableDataPayload;
import lombok.extern.slf4j.Slf4j;

import static com.intellibucket.pipeql.view.topics.CenterStructurePanelTopics.TABLE_SELECTED;

@Slf4j
public class MainCenterTablePanelClient implements AbstractMainCenterTablePanelClient {
    private final EventLinkTemplate eventLinkTemplate = EventLinkTemplate.INSTANCE;
    private final AbstractTableDetailService tableDetailService = DetailServiceFactory.factoryTableDetailService();
    @Override
    public void openTable(TableID tableId) {
        log.info("openTable: {}", tableId);
        var table = tableDetailService.findById(tableId);

        var onlyFailCallback = new OnlyFailCallback() {
            @Override
            public void onFail(FailureEvent event) {
                log.error("onFail: {}", event);
            }
        };

        var message = ProducingMessage.Builder
                .builder()
                .topic(TABLE_SELECTED)
                .event(new StartEvent<>(new TableDataPayload(table)))
                .callback(onlyFailCallback)
                .build();
        this.eventLinkTemplate.publish(message);
    }
}
