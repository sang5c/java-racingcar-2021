package racingcar.ui;

import java.util.Scanner;

import static racingcar.ui.Constants.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

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
