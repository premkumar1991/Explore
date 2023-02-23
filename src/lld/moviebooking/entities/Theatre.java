package lld.moviebooking.entities;

import java.util.List;

public class Theatre {
    String id;
    TheatreStatus status;
    List<Movie> movies;
    List<Screen> screens;
    City city;

    public List<Screen> getScreens() {
        return screens;
    }

    public String getId() {
        return id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public TheatreStatus getStatus() {
        return status;
    }
}
