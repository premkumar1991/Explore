package lld.moviebooking.entities;

import java.util.List;

public class Movie {
    String id;
    String name;
    long durationInMilliSecs;
    List<City> releaseLocation;

    // Todo: Using constructor for initialisation now, but model class are a candidate for builder
    public Movie(String id,String name,long durationInMilliSecs,final List<City> releaseLocation){
        this.id=id;
        this.name=name;
        this.durationInMilliSecs=durationInMilliSecs;
        this.releaseLocation=releaseLocation;
    }

    public String getId() {
        return id;
    }

    public long getDurationInMilliSecs() {
        return durationInMilliSecs;
    }

    public String getName() {
        return name;
    }

    public List<City> getReleaseLocation() {
        return releaseLocation;
    }
}
