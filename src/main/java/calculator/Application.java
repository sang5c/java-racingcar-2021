package calculator;

import calculator.domain.Calculator;

public class Application {

    public static final String RESULT_GUIDE = "계산 결과 : ";

    public static void main(String[] args) {
        String userInput = "2 + 3 * 4 / 2";
        int result = Calculator.execute(userInput);
        System.out.println(RESULT_GUIDE + result);
    }

}
