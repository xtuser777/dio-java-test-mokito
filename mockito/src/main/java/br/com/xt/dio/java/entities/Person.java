package br.com.xt.dio.java.entities;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Person {

    private String name;
    private String document;
    private LocalDate birth;
    private LocationData address;

    public Person(String name, String document, LocalDate birth) {
        this.name = name;
        this.document = document;
        this.birth = birth;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public LocalDate getBirth() {
        return birth;
    }

    public LocationData getAddress() {
        return address;
    }

    public void addLocationData(LocationData data) {
        this.address = data;
    }

    public boolean isAdult() {
        return ChronoUnit.YEARS.between(this.birth, LocalDate.now()) > 18L;
    }
}
