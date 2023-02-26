package lld.moviebooking.service;

import lld.moviebooking.entities.*;
import lld.moviebooking.exceptions.SeatAllocationException;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class BookingService {
    // Concurrent booking cases should be handled here
    // some approaches
    // 1. transaction isolation level setting in sql db
    // 2. prebooking table -> has unique id constraints on three columns <theatre_id,screen_id,seat_id> user_id
    // 3. row lock

    public PreBooking createPreBooking(final Customer customer, final ShowScreen showScreen, final List<Seat> bookingSeats) throws SeatAllocationException {
        if(!isSeatAvailableForPreBooking(showScreen,bookingSeats,customer))
            throw new SeatAllocationException("Seat Prebooking failed", null);
        List<Seat> seats=bookingSeats;
        for (Seat seat:seats){
            seat.setStatus(SeatStatus.Created);
        }
        PreBooking currentPreBooking = new PreBooking(seats,showScreen,customer);
        return currentPreBooking;
    }

    public  Booking createBooking(final PreBooking preBooking) throws SeatAllocationException {
        // check if seats are available in pre-booking table for the customer and seats are in created state
        // if all seats are available in pre-booking table then we can book, otherwise fail the request
        if(!hasPreBookingSeatsExists(preBooking)){
            throw new SeatAllocationException("Seat allocation conflicting with other user", null);
        }
        List<Seat> seats=preBooking.getPreBookedSeats();
        for (Seat seat:seats){
            seat.setStatus(SeatStatus.Booked);
        }
        return new Booking(UUID.randomUUID().toString(),preBooking.getShowScreen(),seats,preBooking.getCustomer());
    }

    // mock pre-booking, in reality it asks middleware for pre-booking list in turn middle ware contacts db/respective store to retrieve details
    private List<PreBooking> getAllPreBookings(){
        ShowScreen showScreen = new ShowScreen("show_id",
                new Date(),
                new Screen("id","name",List.of(new Seat())),
                new Theatre(),
                new Movie("id","name", Duration.ofHours(2).toMillis(),List.of(new City()))
        );
        return List.of(new PreBooking(List.of(new Seat()), showScreen, new Customer()));
    }
    private boolean hasPreBookingSeatsExists(PreBooking preBooking){
        List<PreBooking> preBookings = getAllPreBookings();
        List<PreBooking> preBookingsFiltered = preBookings
                .stream()
                .filter(preBooking1 -> checkPreBookingConstraints(preBooking1, preBooking.getShowScreen())).toList();
        return preBookingsFiltered.size()==1&&preBookingsFiltered.get(0).getPreBookedSeats().size()==preBooking.getPreBookedSeats().size();
    }

    private boolean checkPreBookingConstraints(PreBooking preBooking,ShowScreen screen){
        boolean showMatched = preBooking.getShowScreen().getShowId().equals(screen.getShowId());
        boolean screenMatched = preBooking.getShowScreen().getScreen().getId().equals(screen.getScreen().getId());
        boolean theatreMatched = preBooking.getShowScreen().getTheatre().getId().equals(screen.getTheatre().getId());
        boolean seatMatched = !preBooking.getPreBookedSeats().stream().filter(seat -> hasMatchingSeat(preBooking.getPreBookedSeats(),seat)).toList().isEmpty();
        return showMatched && screenMatched && theatreMatched && seatMatched;
    }

    private boolean hasMatchingSeat(List<Seat> seats, Seat searchSeat){
        return !seats.stream().filter(seat -> seat.getId().equals(searchSeat.getId())).toList().isEmpty();
    }

    // it uses pre-booking table insert approach to check for seat conflict
    // bruteforce approach only, efficient approach can be added later
    private boolean isSeatAvailableForPreBooking(ShowScreen showScreen, List<Seat> bookingSeats,Customer customer){
        // mock data
        List<PreBooking> preBookings = List.of(new PreBooking(List.of(new Seat()), showScreen, new Customer()));
        List<PreBooking> preBookingsFiltered = preBookings.
                stream().
                filter(preBooking -> preBooking.getShowScreen().getShowId().equals(showScreen.getScreen().getShow().getId())).
                filter(preBooking -> preBooking.getShowScreen().getScreen().getId().equals(showScreen.getScreen().getId())).
                filter(preBooking -> preBooking.getShowScreen().getTheatre().getId().equals(showScreen.getTheatre().getId())).toList();
        List<Seat> filteredSeats = new ArrayList<>();
        for(PreBooking preBooking:preBookingsFiltered){
            if(!preBooking.getCustomer().getId().equals(customer.getId())){
                filteredSeats.addAll(preBooking.getPreBookedSeats().stream().filter(seat -> hasMatchingSeat(bookingSeats,seat)).toList());
            }
        }
        return filteredSeats.stream().filter(seat -> hasMatchingSeat(bookingSeats,seat)).toList().isEmpty();
    }


}

//# pre_booking table columns approach
// setting unique key insert constraints on four columns will prevent other user booking same seat
//seat_id screen_id show_id theatre_id customer_id
// 1          1     1        1           123
// 2          1     1        1           123
// 1          1     1        1           456 << insert violates

// Booking table
// booking_id customer_id show_id


