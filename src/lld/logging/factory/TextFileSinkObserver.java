package lld.logging.factory;

import lld.logging.constants.LogLevel;
import lld.logging.builder.LogModel;
import lld.logging.pubsub.SinkObserver;

public class TextFileSinkObserver implements SinkObserver {
    private String logFilePath;
    public TextFileSinkObserver(String logFilePath){
        this.logFilePath=logFilePath;
    }
    @Override
    public void update(LogLevel logLevel, LogModel logModel) {
        System.out.println("TextFileSink invoked for the log level: "+logLevel.name());
    }
}
