package calculator.domain;

public class Number {

    private final int number;

    private Number(int number) {
        this.number = number;
    }

    public static Number ofString(String str) {
        return new Number(Integer.parseInt(str));
    }

    public Number calculate(Operator operator, Number number) {
        int result = operator.run(this.number, number.number);
        return new Number(result);
    }

    public int getNumber() {
        return number;
    }

}
