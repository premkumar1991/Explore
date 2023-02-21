package lld.logging.factory;

import lld.logging.pubsub.SinkObserver;

public interface SinkObserverAbstractFactory {
    SinkObserver create();
}
