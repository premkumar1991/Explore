package lld.logging.builder;

import lld.logging.constants.LogLevel;

import java.time.format.DateTimeFormatter;
import java.util.List;

public class LogModel {
    private LogLevel logLevel;
    private List<String> logMessages;
    private String namespace;
    private DateTimeFormatter dateTimeFormatter;
    private LogModel(Builder builder){
        logLevel=builder.logLevel;
        logMessages=builder.logMessages;
        namespace=builder.namespace;
        dateTimeFormatter=builder.dateTimeFormatter;
    }
    public LogLevel getLogLevel() {
        return logLevel;
    }

    public List<String> getLogMessages() {
        return logMessages;
    }

    public String getNamespace() {
        return namespace;
    }

    public DateTimeFormatter getDateTimeFormatter() {
        return dateTimeFormatter;
    }
    public static class Builder{
        private LogLevel logLevel;
        private List<String> logMessages;
        private String namespace;
        private DateTimeFormatter dateTimeFormatter;
        public Builder(){}

        public Builder setLogLevel(LogLevel logLevel) {
            this.logLevel = logLevel;
            return this;
        }

        public Builder setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
            return this;
        }

        public Builder setLogMessages(List<String> logMessages) {
            this.logMessages = logMessages;
            return this;
        }

        public Builder setNamespace(String namespace) {
            this.namespace = namespace;
            return this;
        }
        public LogModel build(){
            return new LogModel(this);
        }
    }

}
