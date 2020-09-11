package fr.carboatmedia.scamdetector.models;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnalysisTest {

    @InjectMocks
    private ObjectMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void serializeAnalysis() throws IOException {
        String json = """
                  {
                    "reference" : "B300053623",
                    "scam" : true,
                    "rules" : [ "Rule1", "Rule2" ]
                  }      
                """;

        Analysis analysis = new Analysis("B300053623", true, Arrays.asList("Rule1", "Rule2"));
        String output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(analysis);

        System.out.println(json);
        System.out.println(output);

        assertEquals(mapper.readTree(json), mapper.readTree(output));
    }
}
