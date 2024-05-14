package com.intellibucket.pipeql.mgui;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Flow {
    public interface Subscriber <S extends State>{

        default void onSubscribe(Subscription subscription){
            log.info("Executing onSubscribe");
        }

        /**
         * Method invoked with a Subscription's next item.  If this
         * method throws an exception, resulting behavior is not
         * guaranteed, but may cause the Subscription to be cancelled.
         *
         * @param item the item
         */
        default void onNext(S item){
            log.info("Executing onNext");
        }

        /**
         * Method invoked upon an unrecoverable error encountered by a
         * Publisher or Subscription, after which no other Subscriber
         * methods are invoked by the Subscription.  If this method
         * itself throws an exception, resulting behavior is
         * undefined.
         *
         * @param throwable the exception
         */
        default void onError(Throwable throwable){
            log.error("Error {}",throwable.getMessage());
        }

        /**
         * Method invoked when it is known that no additional
         * Subscriber method invocations will occur for a Subscription
         * that is not already terminated by error, after which no
         * other Subscriber methods are invoked by the Subscription.
         * If this method throws an exception, resulting behavior is
         * undefined.
         */
        default void onComplete(){
            log.info("Executing onComplete");
        }

    }

    public interface Subscription{
        void request(long n);

        /**
         * Causes the Subscriber to (eventually) stop receiving
         * messages.  Implementation is best-effort -- additional
         * messages may be received after invoking this method.
         * A cancelled subscription need not ever receive an
         * {@code onComplete} or {@code onError} signal.
         */
         void cancel();
    }
}
