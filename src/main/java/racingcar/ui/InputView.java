package racingcar.ui;

import java.util.Scanner;

public class InputView {

    private static final String GUIDE_INPUT_CAR_COUNT = "자동차 대수는 몇 대 인가요?";
    private static final String GUIDE_INPUT_TRY_COUNT = "시도할 회수는 몇 회 인가요?";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String GUIDE_INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(일므은 쉼표(,)를 기준으로 구분).";

    public static int inputCarCount() {
        printGuide(GUIDE_INPUT_CAR_COUNT);
        return scanner.nextInt();
    }

    public static String inputCarNames() {
        printGuide(GUIDE_INPUT_CAR_NAMES);
        return scanner.nextLine();
    }

    public static int inputTryCount() {
        printGuide(GUIDE_INPUT_TRY_COUNT);
        return scanner.nextInt();
    }

    private static void printGuide(String guide) {
        System.out.println(guide);
    }

}
