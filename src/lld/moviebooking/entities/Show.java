package lld.moviebooking.entities;

import java.util.Date;

public class Show {
    protected String id;
    protected Date startTime;
    protected Date endTime;

    public String getId() {
        return id;
    }

    public Date getTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }
}
