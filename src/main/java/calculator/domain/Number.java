package calculator.domain;

import java.util.Objects;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number ofString(String str) {
        return new Number(Integer.parseInt(str));
    }

    public static Number of(int number) {
        return new Number(number);
    }

    public Number calculate(Operator operator, Number number) {
        int result = operator.run(this.number, number.number);
        return new Number(result);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
