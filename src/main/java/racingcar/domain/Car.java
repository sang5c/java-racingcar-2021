package racingcar.domain;

public class Car {

    private static final int CONDITION = 4;

    private int position;

    public int move() {
        if (RandomGenerator.getRandomNumber() > CONDITION) {
            position++;
        }
        return position;
    }

}
