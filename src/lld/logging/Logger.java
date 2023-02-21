package lld.logging;

import lld.logging.builder.LogConfigModel;
import lld.logging.builder.LogModel;
import lld.logging.constants.LogLevel;
import lld.logging.constants.SinkType;
import lld.logging.factory.SinkObserverAbstractFactory;
import lld.logging.factory.SinkObserverMasterFactory;
import lld.logging.factory.TextFileSinkObserver;
import lld.logging.factory.TextFileSinkObserverFactory;
import lld.logging.pubsub.LogPublisher;
import lld.logging.pubsub.LogPublisherImpl;

import java.util.List;

// singleton as it serves for whole application/service level logging
public class Logger {
    // lock constructor in singleton
    private List<LogConfigModel> logConfigModel;
    private LogPublisher logPublisher;
    private List<LogLevel> logLevels = List.of(LogLevel.Fatal,LogLevel.Error,LogLevel.Info,LogLevel.Warning,LogLevel.Debug);
    private Logger(){}
    private void init(final List<LogConfigModel> logConfigModel,final LogPublisher logPublisher){
        setLogConfig(logConfigModel);
        this.logPublisher=logPublisher;
        initPubSub();
    }
    private void initPubSub(){
        for(LogConfigModel lcm: logConfigModel){
            int endIdx=logLevels.indexOf(lcm.getLogLevel());
            while (endIdx>=0){
                // Todo: detect sink type and associate factory
                // probably simple factory is suffice  for this use case
                SinkObserverAbstractFactory sinkObserverAbstractFactory = getSinkObserver(lcm.getSinkType());
                logPublisher.addObserver(
                        logLevels.get(endIdx--),
                        SinkObserverMasterFactory.getSinkObserver(sinkObserverAbstractFactory)
                );
            }
        }
    }

    private SinkObserverAbstractFactory getSinkObserver(SinkType sinkType){
        SinkObserverAbstractFactory sinkObserverAbstractFactory = null;
        switch (sinkType){
            case TextFile:
                sinkObserverAbstractFactory = new TextFileSinkObserverFactory("dummy_path");
                break;
        }
        return sinkObserverAbstractFactory;
    }
    public void log(final LogLevel logLevel,final LogModel logModel){

    }

    private void setLogConfig(final List<LogConfigModel> logConfigModel){
        this.logConfigModel=logConfigModel;
    }
    private static class LoggerHelper{
        public static final Logger instance = new Logger();
    }
    public static Logger getInstance(final List<LogConfigModel> logConfigModel){
        LoggerHelper.instance.init(logConfigModel, new LogPublisherImpl());
        return LoggerHelper.instance;
    }
}
