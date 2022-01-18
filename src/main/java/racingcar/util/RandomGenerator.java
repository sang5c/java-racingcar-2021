package racingcar.util;

import java.util.Random;

public class RandomGenerator {

    private static final Random RANDOM = new Random();
    private static final int BOUND = 10;

    public static int getRandomNumber() {
        return RANDOM.nextInt(BOUND);
    }

}
