package ch.juventus.model;

import java.util.Map;

public class Apartment {

    private final Map<String, Integer> rooms;
    private final boolean rented;

    public Apartment(Map<String, Integer> rooms, boolean rented) {
        this.rooms = rooms;
        this.rented = rented;
    }

}
