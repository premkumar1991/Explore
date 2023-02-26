package lld.moviebooking.entities;

public class Address {
    String addressLine1;
    String addressLine2;
    String pinCode;
    City city;

    GpsLocation gpsLocation;

    public City getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

}
