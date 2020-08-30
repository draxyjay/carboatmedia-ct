package fr.carboatmedia.scamdetector.rules;

import fr.carboatmedia.scamdetector.models.Deal;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Rule(
        name = "rule::email::number_rate",
        description = "Proportion of numeric character before @ in mail should be lower than 30%"
)
public class EmailNumberRateRule {

    private static final double LIMIT_RATIO = 0.3;

    @Condition
    public boolean isLowerThanLimit(@Fact("emailNumberRate") Deal deal) {
        String strBeforeTheAt = deal.getContact().getEmail().split("@")[0];

        Pattern pattern = Pattern.compile("([\\d])");
        Matcher emailMatcher = pattern.matcher(strBeforeTheAt);
        double nbNumericChar = (double) emailMatcher.results().count();

        return nbNumericChar / strBeforeTheAt.length() < LIMIT_RATIO;
    }

    @Action
    public void ignore() {
    }
}
