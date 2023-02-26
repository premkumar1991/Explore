package lld.moviebooking.entities;

import java.util.List;

public class Theatre {
    private String id;
    private TheatreStatus status;
    private List<Screen> screens;
    private Address address;

    public List<Screen> getScreens() {
        return screens;
    }

    public String getId() {
        return id;
    }

    public TheatreStatus getStatus() {
        return status;
    }

    public Address getAddress() {
        return address;
    }
}
