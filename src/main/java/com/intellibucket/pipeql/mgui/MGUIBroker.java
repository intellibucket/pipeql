package com.intellibucket.pipeql.mgui;

import java.util.*;

public class MGUIBroker {
    private final Map<Class<? extends State>,Channel> broker = new HashMap<>();

    public void register(State state, Flow.Subscriber<?> subscriber){
        if (this.broker.containsKey(state.getClass())){
            this.broker.get(state.getClass()).push(subscriber);
        }else {
            this.broker.put(state.getClass(),new Channel(subscriber));
        }
    }
    

    public static class Channel{
        private Queue<Flow.Subscriber<?>> pipeline = new LinkedList<>();

        public Channel(Flow.Subscriber<?> subscriber){
            this.pipeline.add(subscriber);
        }

        public void push(Flow.Subscriber<?> subscriber){
            this.pipeline.add(subscriber);
        }

        public Optional<Flow.Subscriber<?>> poll(){
            try {
                return Optional.ofNullable(this.pipeline.element());
            }catch (NoSuchElementException e) {
                return Optional.empty();
            }
        }

        public Optional<Flow.Subscriber<?>> peek(){
            return Optional.ofNullable(this.pipeline.peek());
        }

    }
}
