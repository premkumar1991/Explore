package designpatterns.observer;

import java.util.*;

public class NewsEventManager implements NewsSubject {
    Map<NewsEvent,List<NewsObserver>> observers = new HashMap<>();

    @Override
    public void addObserver(NewsEvent newsEvent, NewsObserver observer) {
        observers.putIfAbsent(newsEvent,new ArrayList<>());
        observers.get(newsEvent).add(observer);
    }

    @Override
    public void removeObserver(NewsEvent newsEvent, NewsObserver observer) {
        List<NewsObserver> newsObservers = observers.getOrDefault(newsEvent, new ArrayList<>());
        newsObservers.remove(observer);
    }

    @Override
    public void notifyObservers(NewsEvent event, List<String> messages) {
        List<NewsObserver> newsObservers = observers.getOrDefault(event,new ArrayList<>());
        for(NewsObserver observer: newsObservers){
            observer.update(event, messages);
        }
    }

    @Override
    public void notifyObservers(Map<NewsEvent,List<String>> eventMessages) {
        for(Map.Entry<NewsEvent,List<String>> e:eventMessages.entrySet()){
            List<NewsObserver> newsObservers = observers.getOrDefault(e.getKey(),new ArrayList<>());
            for(NewsObserver newsObserver:newsObservers){
                newsObserver.update(e.getKey(),e.getValue());
            }
        }
    }

    @Override
    public void setState(NewsEvent newsEvent, List<String> messages) {
        notifyObservers(newsEvent,messages);
    }

    @Override
    public void setState(Map<NewsEvent, List<String>> eventMessages) {
        for(Map.Entry<NewsEvent,List<String>> e:eventMessages.entrySet()){
            for(NewsObserver newsObserver:observers.getOrDefault(e.getKey(),new ArrayList<>())){
                newsObserver.update(e.getKey(),e.getValue());
            }
        }
    }
}
