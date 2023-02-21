package lld.logging.pubsub;

import lld.logging.constants.LogLevel;
import lld.logging.builder.LogModel;

public interface LogPublisher {
    void addObserver(LogLevel logLevel, SinkObserver sinkObserver);
    void removeObserver(LogLevel logLevel,SinkObserver sinkObserver);
    void notifyObservers();
    void setState(LogLevel logLevel, LogModel logModel);
}
