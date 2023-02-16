# Simple NewsLetters design using observer pattern
# use cases
    - user can subscribe to specific news letter topics like health, sports, daily_news
    - once the news is ready for the topic, news system will notify the subscriber for the topic

```
>> client class
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