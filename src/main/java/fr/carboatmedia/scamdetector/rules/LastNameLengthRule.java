package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "rule::lastname::length", description = "Last name should be longer than 2")
public class LastNameLengthRule {

    private static final int MIN_LENGTH = 2;

    @Condition
    public boolean isLongerThanMinLength(@Fact("lastName") Deal deal) {
        return deal.getContact().getLastName().length() > MIN_LENGTH;
    }

    @Action
    public void ignore() {
    }
}
