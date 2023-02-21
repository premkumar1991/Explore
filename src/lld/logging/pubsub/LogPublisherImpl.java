package lld.logging.pubsub;

import lld.logging.constants.LogLevel;
import lld.logging.builder.LogModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogPublisherImpl implements LogPublisher {
public LogPublisherImpl(){}
    private LogLevel logLevel;
    private LogModel logModel;
    Map<LogLevel, List<SinkObserver>> sinkObservers = new HashMap<>();
    @Override
    public void addObserver(LogLevel logLevel, SinkObserver sinkObserver) {
        sinkObservers.put(logLevel,sinkObservers.getOrDefault(logLevel,new ArrayList<>()));
        sinkObservers.get(logLevel).add(sinkObserver);
    }

    @Override
    public void removeObserver(LogLevel logLevel,SinkObserver sinkObserver) {
        List<SinkObserver> sinkObserverList = sinkObservers.getOrDefault(logLevel,new ArrayList<>());
        sinkObserverList.remove(sinkObserver);
    }

    @Override
    public void notifyObservers() {
        List<SinkObserver> sinkObserverList = sinkObservers.getOrDefault(logLevel,new ArrayList<>());
        for(SinkObserver sinkObserver: sinkObserverList){
            sinkObserver.update(logLevel,logModel);
        }
    }

    @Override
    public void setState(LogLevel logLevel, LogModel logModel) {
        this.logLevel=logLevel;
        this.logModel=logModel;
        notifyObservers();
    }
}
