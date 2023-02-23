package lld.moviebooking.entities;

import java.time.OffsetDateTime;

public class Show {
    String id;
    OffsetDateTime time;
    Screen screen;

    public String getId() {
        return id;
    }

    public OffsetDateTime getTime() {
        return time;
    }

    public Screen getScreen() {
        return screen;
    }
}
