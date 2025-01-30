package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.model.Apartment;
import ch.juventus.model.Property;

import java.util.Collections;
import java.util.List;

public class PropertyService {

    private final Database database;

    public PropertyService(Database database) {
        this.database = database;
    }

    public List<Property> getAllProperties() {
        return database.getAllProperties();
    }

    public List<Apartment> getAllFreeApartments() {
        return Collections.emptyList();
    }

    public List<Property> getAllPropertiesInCity(String city) {
        return Collections.emptyList();
    }

    public List<Apartment> getAllApartmentsSortedByNumberOfRooms() {
        return Collections.emptyList();
    }

    public List<Apartment> getAllFreeApartments() {
        return database.getAllProperties().stream()
                .flatMap(property -> property.getApartments().stream())
                .filter(apartment -> !apartment.isRented())
                .collect(Collectors.toList());
    }

    public List<Property> getAllPropertiesInCity(String city) {
        return database.getAllProperties().stream()
                .filter(property -> property.getAddress().getCity().equalsIgnoreCase(city))
                .collect(Collectors.toList());
    }

    public List<Apartment> getAllApartmentsSortedByNumberOfRooms() {
        return database.getAllProperties().stream()
                .flatMap(property -> property.getApartments().stream())
                .sorted(Comparator
                        .comparingInt(apartment -> apartment.getRooms().values().stream().mapToInt(Integer::intValue).sum())
                        .thenComparing(Apartment::isRented))
                .collect(Collectors.toList());
    }

}
