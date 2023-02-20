package designpatterns.observer.newsletter;

import java.util.List;

public class NewsEventObserver implements NewsObserver {
    private String observerName;
    public NewsEventObserver(String observerName){
        this.observerName = observerName;
    }
    @Override
    public void update(NewsEvent newsEvent, List<String> messages) {
        System.out.println(observerName + " received "+ messages.size() +" messages for the event: "+newsEvent.name());
        for(String message: messages)
            System.out.println(message);
    }
}
