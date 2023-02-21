package lld.logging.factory;

import lld.logging.pubsub.SinkObserver;

public class TextFileSinkObserverFactory implements SinkObserverAbstractFactory {
    private String logFilePath;
    public TextFileSinkObserverFactory(String logFilePath){
        this.logFilePath=logFilePath;
    }

    @Override
    public SinkObserver create() {
        return new TextFileSinkObserver(logFilePath);
    }
}
