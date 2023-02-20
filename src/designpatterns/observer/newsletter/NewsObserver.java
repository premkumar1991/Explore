package designpatterns.observer.newsletter;

import java.util.List;

public interface NewsObserver {
   void update(NewsEvent newsEvent, List<String> messages);
}
