package lld.moviebooking.entities;

import java.util.List;

//public class Booking {
//    String bookingId;
//    String theatreId;
//    String movieId;
//    String screenId;
//    List<Seat>  bookedSeats;
//    Customer customer;
//
//}

//why don't i keep Screen entity,Customer
public class Booking {
    private String bookingId;
    private ShowScreen showScreen;
    private List<Seat> bookedSeats;
    private Customer customer;
    public Booking(String bookingId,final ShowScreen showScreen,final List<Seat> bookedSeats,final Customer customer){
        this.bookingId=bookingId;
        this.showScreen=showScreen;
        this.bookedSeats=bookedSeats;
        this.customer=customer;
    }

}
