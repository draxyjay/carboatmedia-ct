package fr.carboatmedia.scamdetector.enums;

public enum PublicationOptionsEnum {
    STRENGTHS("STRENGTHS"),
    BOOST_VO("BOOST_VO");

    private String name;

    PublicationOptionsEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
