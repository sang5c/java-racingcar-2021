package racingcar.domain.move;

import racingcar.util.RandomGenerator;

public class RandomMoveStrategy implements MoveStrategy {

    private static final int CONDITION = 4;

    @Override
    public boolean canMove() {
        return RandomGenerator.getRandomNumber() > CONDITION;
    }

}
