package calculator.domain;

import java.util.List;
import static calculator.util.Constants.SPLIT_REGEX;

public class Formula {

    private final List<String> formula;

    private Formula(List<String> formula) {
        this.formula = formula;
    }

    public static Formula from(String str) {
        String[] split = str.split(SPLIT_REGEX);
        return new Formula(List.of(split));
    }

    public int execute() {
        Number result = Number.ofString(formula.get(0));
        for (int i = 1; i < formula.size() - 1; i += 2) {
            Operator operator = Operator.from(formula.get(i));
            Number rightNumber = Number.ofString(formula.get(i + 1));
            result = result.calculate(operator, rightNumber);
        }

        return result.getNumber();
    }

}
