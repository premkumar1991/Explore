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
    private Screen screen;
    private Customer customer;
    public Booking(String bookingId,Screen screen,Customer customer){
        this.bookingId=bookingId;
        this.screen=screen;
        this.customer=customer;
    }

}
