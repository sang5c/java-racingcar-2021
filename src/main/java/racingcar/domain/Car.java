package racingcar.domain;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String ERROR_INVALID_CAR_NAME = "자동차 이름이 없거나 너무 깁니다";

    private final String name;
    private final MoveStrategy moveStrategy;

    private int position;

    public Car(String name, MoveStrategy moveStrategy) {
        validate(name);
        this.name = name;
        this.moveStrategy = moveStrategy;
    }

    private void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAME);
        }
    }

    public MoveResult move() {
        if (moveStrategy.canMove()) {
            position++;
        }
        return new MoveResult(name, position);
    }

}
