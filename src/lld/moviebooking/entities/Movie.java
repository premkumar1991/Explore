package lld.moviebooking.entities;

import java.time.Duration;
import java.util.List;

public class Movie {
    String id;
    String name;
    long durationInMilliSecs;
    List<City> city;
    // Todo: Using constructor for initialisation now, but model class are a candidate for builder
    public Movie(String id,String name,long durationInMilliSecs,List<City> city){
        this.id=id;
        this.city=city;
        this.name=name;
        this.durationInMilliSecs=durationInMilliSecs;
    }

    public String getId() {
        return id;
    }

    public List<City> getCity() {
        return city;
    }

    public long getDurationInMilliSecs() {
        return durationInMilliSecs;
    }

    public String getName() {
        return name;
    }
}
