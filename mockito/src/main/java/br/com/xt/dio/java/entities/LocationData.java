package br.com.xt.dio.java.entities;

public class LocationData {

    private String state;
    private String city;
    private String street;
    private String complement;
    private String neighborhood;

    public LocationData(String state, String city, String street, String complement, String neighborhood) {
        this.state = state;
        this.city = city;
        this.street = street;
        this.complement = complement;
        this.neighborhood = neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }
}
