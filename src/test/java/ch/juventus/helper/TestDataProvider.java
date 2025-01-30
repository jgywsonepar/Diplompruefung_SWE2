package ch.juventus.helper;

import ch.juventus.model.Address;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class TestDataProvider {

    public static List<Property> emptyList() {
        return Collections.emptyList();
    }

    public static List<Property> propertyList() {
        return List.of(
                new Property(null, null),
                new Property(null, null),
                new Property(null, null),
                new Property(null, null),
                new Property(null, null),
                new Property(null, null)
        );
    }

    public static List<Property> propertyListWithDetails() {
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

        return List.of(property1, property2, property3);
    }

    public static List<Apartment> sortedApartments() {
        return List.of(
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 4), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 4), false),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 3), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 3), false),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 2), true),
                new Apartment(Map.of("Bathroom", 2, "Livingroom", 1, "Bedroom", 2), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 2), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), false),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), true),
                new Apartment(Map.of("Bathroom", 1, "Livingroom", 1, "Bedroom", 1), fase)
        );
    }
}
