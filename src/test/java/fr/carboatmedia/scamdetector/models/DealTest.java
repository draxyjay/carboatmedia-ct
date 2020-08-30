package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DealTest {
    
    @InjectMocks
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deserializeDeal() throws IOException {
        String json = "{\n" +
                "  \"contacts\": {\n" +
                "    \"firstName\": \"Christophe\",\n" +
                "    \"lastName\": \"Dupont\",\n" +
                "    \"email\": \"testdepot@yopmail.fr\",\n" +
                "    \"phone1\": {\n" +
                "      \"value\": \"0607080901\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"creationDate\": \"2020-01-09T09:02:22.610Z\",\n" +
                "  \"price\": 19000,\n" +
                "  \"publicationOptions\": [\"STRENGTHS\", \"BOOST_VO\"],\n" +
                "  \"reference\": \"B300053623\",\n" +
                "  \"vehicle\": {\n" +
                "    \"make\": \"HONDA\",\n" +
                "    \"model\": \"CR-V\",\n" +
                "    \"version\": \"IV (2) 1.6 I-DTEC 160 4WD EXCLUSIVE NAVI AT\",\n" +
                "    \"category\": \"SUV_4X4_CROSSOVER\",\n" +
                "    \"registerNumber\": \"AA123AA\",\n" +
                "    \"mileage\": 100000\n" +
                "  }\n" +
                "}";

        Deal deal = mapper.readValue(json, Deal.class);

        assertEquals("B300053623", deal.getReference());
        assertNotNull(deal.getPublicationOptions());
        assertEquals(2, deal.getPublicationOptions().size());
        assertNotNull(deal.getCreationDate());
        assertNotNull(deal.getContact());
        assertNotNull(deal.getVehicle());
    }
}
