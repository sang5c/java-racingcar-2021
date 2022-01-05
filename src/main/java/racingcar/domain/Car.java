package racingcar.domain;

public class Car {

    private int position;
    private final MoveStrategy moveStrategy;

    public Car(MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
    }

    public int move() {
        if (moveStrategy.canMove()) {
            position++;
        }
        return position;
    }

}
