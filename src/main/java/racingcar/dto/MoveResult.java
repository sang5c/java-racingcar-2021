package racingcar.dto;

public class MoveResult {
    private final String name;
    private final int position;

    public MoveResult(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

}
