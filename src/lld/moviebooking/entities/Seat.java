package lld.moviebooking.entities;

// how screen to seat association happens
// Some theatre screen seat_no seat_status mapping table would be there
// single mapping table
// theatre_id screen_id seat_no seat_available
// booking table
// show all available seats in theater x, screen y
// for now, most of the seats are 2D sparse matrix

public class Seat {
    String id;
    String row;
    String col;
    SeatStatus status;
    SeatCategory category;

    public String getId() {
        return id;
    }

    public SeatCategory getCategory() {
        return category;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public String getCol() {
        return col;
    }

    public String getRow() {
        return row;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
