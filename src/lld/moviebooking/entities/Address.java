package lld.moviebooking.entities;

public class Address {
    String streetName;
    String pinCode;
    City city;

    public City getCity() {
        return city;
    }

    public String getPinCode() {
        return pinCode;
    }

    public String getStreetName() {
        return streetName;
    }
}
