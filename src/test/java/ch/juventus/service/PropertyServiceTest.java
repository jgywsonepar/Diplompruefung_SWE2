package ch.juventus.service;

import ch.juventus.database.Database;
import ch.juventus.helper.TestDataProvider;
import ch.juventus.model.Property;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
class PropertyServiceTest {

    @Mock
    private Database database;
    private PropertyService propertyService;

    @BeforeEach
    public void setup() {
        propertyService = new PropertyService(database);
    }

    @Test
    void testGetAllProperties() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyList());

        // When
        List<Property> properties = propertyService.getAllProperties();

        // Then
        assertEquals(6, properties.size());
    }

    @Test
    void testGetAllPropertiesWithEmptyList() {
        // Given
        when(database.getAllProperties()).thenReturn(TestDataProvider.emptyList());

        // When
        List<Property> properties = propertyService.getAllProperties();

        // Then
        assertEquals(0, properties.size());
    }

    @Test
    void testGetAllFreeApartments() {
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyList());
        List<Apartment> freeApartments = propertyService.getAllFreeApartments();
        assertEquals(4, freeApartments.size());
        assertFalse(freeApartments.stream().anyMatch(Apartment::isRented));
    }

    @Test
    void testGetAllPropertiesInCity() {
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyList());
        List<Property> propertiesInCity = propertyService.getAllPropertiesInCity("Altstetten");
        assertEquals(2, propertiesInCity.size());
        assertTrue(propertiesInCity.stream().allMatch(p -> p.getAddress().getCity().equalsIgnoreCase("Altstetten")));
    }

    @Test
    void testGetAllApartmentsSortedByNumberOfRooms() {
        when(database.getAllProperties()).thenReturn(TestDataProvider.propertyList());
        List<Apartment> sortedApartments = propertyService.getAllApartmentsSortedByNumberOfRooms();
        assertEquals(6, sortedApartments.size());
        for (int i = 1; i < sortedApartments.size(); i++) {
            int prevRooms = sortedApartments.get(i - 1).getRooms().values().stream().mapToInt(Integer::intValue).sum();
            int currRooms = sortedApartments.get(i).getRooms().values().stream().mapToInt(Integer::intValue).sum();
            assertTrue(prevRooms <= currRooms);
        }
    }

}
