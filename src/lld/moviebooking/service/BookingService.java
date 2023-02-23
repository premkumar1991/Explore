package lld.moviebooking.service;

import lld.moviebooking.entities.*;

import java.util.ArrayList;
import java.util.List;

public class BookingService {
    // Concurrent booking cases should be handled here
    // some approaches
    // 1. transaction isolation level setting in sql db
    // 2. prebooking table -> has unique id constraints on three columns <theatre_id,screen_id,seat_id> user_id
    // 3. row lock

    // v1/api/book/seats
    //{ userId,screenId,List<Seats> }
    public Booking bookSeats(String customerId, String screenId, List<Seat> bookingSeats){
        if(!isSeatAvailableForScreen(screenId,bookingSeats))
            throw new IllegalStateException("Seat conflicted");
        return new Booking("123",new Screen(),new Customer());
    }
    private boolean isSeatAvailableForScreen(String screenId, List<Seat> bookingSeats){
        Screen screen = new Screen();
        return screen.
                getSeats().
                stream().
                filter(seat -> isSeatAvailable(bookingSeats,seat)).
                toList().
                size()==bookingSeats.size();
    }
    private boolean isSeatAvailable(List<Seat> seats,Seat searchSeat){
        return seats
                .stream()
                .filter(seat -> seat.getId().equals(searchSeat.getId()) && seat.getStatus().equals(SeatStatus.Not_Booked))
                .toList()
                .size() == seats.size();
    }
}
