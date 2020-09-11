package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.enums.PublicationOptionsEnum;
import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Rule(
        name = "rule::publication_option::valid",
        description = "If publication options of a deal are valid",
        priority=1
)
public class PublicationOptionsRule {

    @Condition
    public boolean isPublicationOptionValid(@Fact("publicationOption") Deal deal) {
        List<String> publicationOptions = deal.getPublicationOptions();

        return Arrays.stream(PublicationOptionsEnum.values())
                .map(PublicationOptionsEnum::getName)
                .collect(Collectors.toList())
                .stream().anyMatch(publicationOptions::contains);
    }

    @Action
    public void ignore() {
    }
}
