package calculator.domain;

import calculator.util.Utils;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static calculator.util.Constants.SPLIT_REGEX;

public class Calculator {

    public static int execute(String formula) {
        String[] split = formula.split(SPLIT_REGEX);
        List<Number> numbers = toNumbers(split);
        Queue<Operator> operators = toOperators(split);

        return numbers.stream()
                .reduce((x, y) -> x.calculate(operators.remove(), y))
                .orElseThrow()
                .getNumber();
    }

    private static PriorityQueue<Operator> toOperators(String[] split) {
        return IntStream.range(0, split.length)
                .filter(Utils::isOdd)
                .mapToObj(v -> Operator.from(split[v]))
                .collect(Collectors.toCollection(PriorityQueue::new));
    }

    private static List<Number> toNumbers(String[] split) {
        return IntStream.range(0, split.length)
                .filter(Utils::isEven)
                .mapToObj(v -> Number.ofString(split[v]))
                .collect(Collectors.toList());
    }

}
