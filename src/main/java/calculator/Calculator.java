package calculator;

import static calculator.Operator.*;

public class Calculator {

    public static int calculate(String symbol, int left, int right) {
        Operator operator = ofString(symbol);
        return operator.calculate(left, right);
    }

}
