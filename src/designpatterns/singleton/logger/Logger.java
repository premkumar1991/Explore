package designpatterns.singleton.logger;

import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private FileWriter fw;
    private Logger() throws IOException {
        fw=new FileWriter("random.txt");
    }
    private static class LoggerHelper{
        private static final Logger instance;

        static {
            try {
                instance = new Logger();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static Logger getInstance(){
        return LoggerHelper.instance;
    }
    public void commit(String logString) throws IOException {
        fw.write(logString);
        fw.write('\n');
    }
    public void close() throws IOException {
        fw.close();
    }
}
