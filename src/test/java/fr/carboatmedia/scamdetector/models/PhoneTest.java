package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PhoneTest {
    
    @InjectMocks
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void deserializePhone() throws IOException {
        String json = String.format("{\"value\":%s}", "\"0607080901\"");
        Phone phone = mapper.readValue(json, Phone.class);

        assertEquals("0607080901", phone.getValue());
    }
}
