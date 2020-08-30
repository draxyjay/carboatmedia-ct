package fr.carboatmedia.scamdetector.models;

import java.util.ArrayList;
import java.util.List;

public class Analysis {

    private String reference;
    private boolean scam;
    private List<String> rules;

    public Analysis() {
        this.rules = new ArrayList<>();
    }

    public Analysis(String reference, boolean scam, List<String> rules) {
        this();
        this.reference = reference;
        this.scam = scam;
        this.rules = rules;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public boolean isScam() {
        return scam;
    }

    public void setScam(boolean scam) {
        this.scam = scam;
    }

    public List<String> getRules() {
        return rules;
    }

    public void addRule(String rule) {
        this.rules.add(rule);
    }
}
