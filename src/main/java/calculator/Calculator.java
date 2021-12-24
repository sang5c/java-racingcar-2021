package calculator;

public class Calculator {

    public static final int ZERO = 0;
    public static final String PLUS = "+";
    public static final String MINUS = "-";
    public static final String MULTIPLY = "*";
    public static final String DIVIDE = "/";
    public static final String ERROR_INVALID_OPERATOR = "유효하지 않은 연산자입니다: ";
    public static final String ERROR_DIVIDE_ZERO = "divide by zero";

    public static int calculate(String operator, int left, int right) {
        if (PLUS.equals(operator)) {
            return add(left, right);
        } else if (MINUS.equals(operator)) {
            return minus(left, right);
        } else if (MULTIPLY.equals(operator)) {
            return multiply(left, right);
        } else if (DIVIDE.equals(operator)) {
            return divide(left, right);
        } else {
            throw new IllegalArgumentException(ERROR_INVALID_OPERATOR + operator);
        }
    }

    private static int add(int left, int right) {
        return left + right;
    }

    private static int minus(int left, int right) {
        return left - right;
    }

    private static int multiply(int left, int right) {
        return left * right;
    }

    private static int divide(int left, int right) {
        if (right == ZERO) {
            throw new IllegalArgumentException(ERROR_DIVIDE_ZERO);
        }
        return left / right;
    }

}
