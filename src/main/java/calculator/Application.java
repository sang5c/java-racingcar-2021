package calculator;

public class Application {

    public static void main(String[] args) {
        String userInput = "2 + 3 * 4 / 2";
        String[] split = userInput.split(" ");
        int left = Integer.parseInt(split[0]);
        for (int i = 1; i < split.length - 1; i += 2) {
            String symbol = split[i];
            int right = Integer.parseInt(split[i + 1]);
            left = Calculator.calculate(symbol, left, right);
        }
        System.out.println("계산 결과 : " + left);
    }

}
