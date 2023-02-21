package designpatterns.observer.newsletter;

import designpatterns.observer.newsletter.NewsEvent;
import designpatterns.observer.newsletter.NewsEventManager;
import designpatterns.observer.newsletter.NewsEventObserver;
import designpatterns.observer.newsletter.NewsObserver;

import java.util.List;
import java.util.Map;

public class Client {
    public static void main(String[] args){
        NewsObserver mo1 = new NewsEventObserver("Observer1");
        NewsObserver mo2 = new NewsEventObserver("Observer2");
        NewsEventManager mem = new NewsEventManager();
        mem.addObserver(NewsEvent.Health, mo1);
        mem.addObserver(NewsEvent.Sports, mo2);
        mem.setState(NewsEvent.Health, List.of("hello"));
        mem.setState(Map.of(NewsEvent.Sports,List.of("IPL match"),NewsEvent.Health,List.of("Healthy lifestyle program")));

    }
}

/**
 * Todo
 * 1. Make observers pattern in multi threading way
 * 2. Check the relevant collections or STL's for concurrency support
 * 3. Understand best practises of concurrency
 */