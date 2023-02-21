package lld.logging.builder;

import lld.logging.constants.LogLevel;
import lld.logging.constants.SinkType;

import java.time.format.DateTimeFormatter;

// Builder
public class LogConfigModel {
    private LogLevel logLevel;
    private DateTimeFormatter dateTimeFormatter;
    private String sinkDBEndpoint;
    private String logFilePath;
    private SinkType sinkType;
    private LogConfigModel(Builder builder){
        logLevel=builder.logLevel;
        dateTimeFormatter=builder.dateTimeFormatter;
        sinkDBEndpoint=builder.sinkDBEndpoint;
        logFilePath=builder.logFilePath;
        sinkType=builder.sinkType;
    }

    public SinkType getSinkType() {
        return sinkType;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public String getSinkDBEndpoint() {
        return sinkDBEndpoint;
    }
    public static class Builder{
        private LogLevel logLevel;
        private DateTimeFormatter dateTimeFormatter;
        private String sinkDBEndpoint;
        private String logFilePath;
        private SinkType sinkType;

        public Builder setSinkType(SinkType sinkType) {
            this.sinkType = sinkType;
            return this;
        }

        public Builder setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
            return this;
        }

        public Builder setLogFilePath(String logFilePath) {
            this.logFilePath = logFilePath;
            return this;
        }

        public Builder setLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Builder setSinkDBEndpoint(String sinkDBEndpoint) {
            this.sinkDBEndpoint = sinkDBEndpoint;
            return this;
        }
        public LogConfigModel build(){
            return new LogConfigModel(this);
        }
    }
}
