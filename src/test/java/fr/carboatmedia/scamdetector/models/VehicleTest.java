package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VehicleTest {
    
    @InjectMocks
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deserializeVehicle() throws IOException {
        String json = "{\n" +
                "    \"make\": \"HONDA\",\n" +
                "    \"model\": \"CR-V\",\n" +
                "    \"version\": \"IV (2) 1.6 I-DTEC 160 4WD EXCLUSIVE NAVI AT\",\n" +
                "    \"category\": \"SUV_4X4_CROSSOVER\",\n" +
                "    \"registerNumber\": \"AA123AA\",\n" +
                "    \"mileage\": 100000\n" +
                "  }";

        Vehicle vehicle = mapper.readValue(json, Vehicle.class);

        assertEquals("HONDA", vehicle.getMake());
        assertEquals("CR-V", vehicle.getModel());
        assertEquals("IV (2) 1.6 I-DTEC 160 4WD EXCLUSIVE NAVI AT", vehicle.getVersion());
        assertEquals("SUV_4X4_CROSSOVER", vehicle.getCategory());
        assertEquals("AA123AA", vehicle.getRegisterNumber());
        assertEquals(100000, vehicle.getMileage());
    }
}
