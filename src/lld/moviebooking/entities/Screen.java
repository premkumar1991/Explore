package lld.moviebooking.entities;

import java.util.List;

public class Screen {
    String id;
    String name;
    List<Seat> seats;
    Movie movie;
    Theatre theatre;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Seat> getSeats() {
        return seats;
    }
    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }
}
