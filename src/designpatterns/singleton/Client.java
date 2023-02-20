package designpatterns.singleton;

import designpatterns.singleton.logger.Logger;

import java.io.IOException;

public class Client {
    public static void main(String[] args) throws IOException {
        Logger log = Logger.getInstance();
        String[] logStreams=new String[]{"hello","1"};
        for(String logStream:logStreams)
            log.commit(logStream);
        log.close();
        log.commit("aa");
    }
}
