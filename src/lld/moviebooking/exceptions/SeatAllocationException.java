package lld.moviebooking.exceptions;

public class SeatAllocationException extends Exception{
    public SeatAllocationException(String errorMessage, Throwable error){
        super(errorMessage, error);
    }
}
