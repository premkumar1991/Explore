package lld.logging.pubsub;

import lld.logging.constants.LogLevel;
import lld.logging.builder.LogModel;

public interface SinkObserver {
    void update(LogLevel logLevel, LogModel logModel);
}
