package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "rule::firstname::length", description = "First name should be longer than 2")
public class FirstNameLengthRule {

    private static final int MIN_LENGTH = 2;

    @Condition
    public boolean isLongerThanMinLength(@Fact("firstName") Deal deal) {
        return deal.getContact().getFirstName().length() > MIN_LENGTH;
    }

    @Action
    public void ignore() {
    }
}
