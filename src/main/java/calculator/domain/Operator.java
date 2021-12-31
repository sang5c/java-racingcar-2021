package calculator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

import static calculator.util.Constants.*;

public enum Operator {
    PLUS("+", Integer::sum),
    MINUS("-", (left, right) -> left - right),
    MULTIPLY("*", (left, right) -> left * right),
    DIVIDE("/", (left, right) -> {
        if (right == ZERO) {
            throw new IllegalArgumentException(ERROR_DIVIDE_ZERO);
        }
        return left / right;
    }),
    ;

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public static Operator from(String symbol) {
        return Arrays.stream(values())
                .filter(s -> s.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_INVALID_OPERATOR + symbol));
    }

    public int run(int left, int right) {
        return biFunction.apply(left, right);
    }
}
