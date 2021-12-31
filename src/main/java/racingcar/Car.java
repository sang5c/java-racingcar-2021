package racingcar;

import java.util.Random;

public class Car {

    private int position;

    public int move() {
        Random random = new Random();
        if (random.nextInt(10) > 4) {
            position++;
        }
        return position;
    }

}
