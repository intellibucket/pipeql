package com.intellibucket.pipeql.eventlink.model.payload;

public class EmptySuccessPayload extends SuccessPayload {
    public static final EmptySuccessPayload INSTANCE = new EmptySuccessPayload();

    private EmptySuccessPayload() {
        super();
    }
}
