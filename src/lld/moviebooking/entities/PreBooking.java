package lld.moviebooking.entities;

import java.util.List;

public class PreBooking {
    private List<Seat> preBookedSeats;
    ShowScreen showScreen;
    private Customer customer;
    public PreBooking(final List<Seat> preBookedSeats,final ShowScreen showScreen,final Customer customer){
        this.preBookedSeats=preBookedSeats;
        this.showScreen=showScreen;
        this.customer=customer;
    }

    public List<Seat> getPreBookedSeats() {
        return preBookedSeats;
    }

    public Customer getCustomer() {
        return customer;
    }

    public ShowScreen getShowScreen() {
        return showScreen;
    }
}
