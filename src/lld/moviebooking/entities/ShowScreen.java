package lld.moviebooking.entities;

import java.util.Date;

public class ShowScreen {
    String showId;
    Date showTime;
    Screen screen;
    Theatre theatre;
    Movie movie;
    public ShowScreen(String showId,Date showTime,Screen screen,Theatre theatre,Movie movie){
        this.showId=showId;
        this.showTime=showTime;
        this.screen=screen;
        this.theatre=theatre;
        this.movie=movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public Date getShowTime() {
        return showTime;
    }

    public String getShowId() {
        return showId;
    }

    public Theatre getTheatre() {
        return theatre;
    }
}
