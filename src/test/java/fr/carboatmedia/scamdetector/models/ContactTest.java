package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContactTest {

    @InjectMocks
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deserializeContact() throws IOException {
        String json = "{\n" +
                "    \"firstName\": \"Christophe\",\n" +
                "    \"lastName\": \"Dupont\",\n" +
                "    \"email\": \"testdepot@yopmail.fr\",\n" +
                "    \"phone1\": {\n" +
                "      \"value\": \"0607080901\"\n" +
                "    }\n" +
                "  }";

        Contact contact = mapper.readValue(json, Contact.class);

        assertEquals("Christophe", contact.getFirstName());
        assertEquals("Dupont", contact.getLastName());
        assertEquals("testdepot@yopmail.fr", contact.getEmail());
        assertEquals("0607080901", contact.getPhone().getValue());
    }
}
