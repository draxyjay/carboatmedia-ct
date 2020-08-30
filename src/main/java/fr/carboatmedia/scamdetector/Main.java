package fr.carboatmedia.scamdetector;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.carboatmedia.scamdetector.models.Analysis;
import fr.carboatmedia.scamdetector.models.Deal;
import fr.carboatmedia.scamdetector.services.ScamDetectorService;

import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ScamDetectorService scamDetectorService = new ScamDetectorService();

            String json = Files.readString(Path.of(Main.class.getClassLoader().getResource("doc.json").toURI()));
            Deal deal = mapper.readValue(json, Deal.class);

            Analysis analysis = scamDetectorService.analyze(deal);
            String output = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(analysis);

            System.out.println(output);
        } catch (Exception ignored) {
            System.out.println("Failed to detect scam");
        }
    }
}

