package lld.logging.factory;

import lld.logging.pubsub.SinkObserver;

public class SinkObserverMasterFactory {
    public static SinkObserver getSinkObserver(SinkObserverAbstractFactory sinkObserverAbstractFactory){
        return sinkObserverAbstractFactory.create();
    }
}
