package ch.juventus.database;

import ch.juventus.model.Address;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.List;
import java.util.Map;

public class Database {

    private static Database INSTANCE;
    private final List<Property> properties;

    private Database() {

        Address address1 = new Address("Feldblumenstrasse", 40, "Altstetten", 8048);
        List<Apartment> apartments1 = List.of(
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 3), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 2), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 4), false)
        );
        Property property1 = new Property(address1, apartments1);

        Address address2 = new Address("Rötelsteig", 6, "Wipkingen", 8038);
        List<Apartment> apartments2 = List.of(
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 2), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 3), false)
        );
        Property property2 = new Property(address2, apartments2);

        Address address3 = new Address("Heimstrasse", 8, "Dietikon", 8953);
        List<Apartment> apartments3 = List.of(
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 2), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 4), false)
        );
        Property property3 = new Property(address3, apartments3);

        properties = List.of(property1, property2, property3);
    }

    public static Database getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Database();
        }
        return INSTANCE;
    }

    public List<Property> getAllProperties() {
        return properties;
    }
}
