package designpatterns.observer.newsletter;

import java.util.List;
import java.util.Map;

public interface NewsSubject {
    void addObserver(NewsEvent newsEvent,NewsObserver observer);
    void removeObserver(NewsEvent newsEvent, NewsObserver observer);

    void notifyObservers(NewsEvent newsEvent, List<String> messages);
    void notifyObservers(Map<NewsEvent,List<String>> eventMessages);

    void setState(NewsEvent newsEvent, List<String> messages);
    void setState(Map<NewsEvent,List<String>> eventMessages);
}

