package lld.logging.pubsub;

import lld.logging.constants.LogLevel;
import lld.logging.builder.LogModel;

public class ConsoleSinkObserver implements SinkObserver {
    public ConsoleSinkObserver(){}
    @Override
    public void update(LogLevel logLevel, LogModel logModel) {
        System.out.println("ConsoleSinkObserver invoked for the log level: "+logLevel.name());
    }
}
