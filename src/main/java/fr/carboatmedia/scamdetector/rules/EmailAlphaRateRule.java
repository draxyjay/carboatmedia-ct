package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Rule(
        name = "rule::email::alpha_rate",
        description = "Proportion of alphanumeric character before @ in mail should be greater than 70%"
)
public class EmailAlphaRateRule {

    private static final double LIMIT_RATIO = 0.7;

    @Condition
    public boolean isGreaterThanLimit(@Fact("emailAlphaRate") Deal deal) {
        String strBeforeTheAt = deal.getContact().getEmail().split("@")[0];

        Pattern pattern = Pattern.compile("([0-9a-zA-Z])");
        Matcher emailMatcher = pattern.matcher(strBeforeTheAt);
        double nbAlphaNumericChar = (double) emailMatcher.results().count();

        return nbAlphaNumericChar / strBeforeTheAt.length() > LIMIT_RATIO;
    }

    @Action
    public void ignore() {
    }
}
