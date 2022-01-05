package racingcar.dto;

import java.util.Collections;
import java.util.List;

public class RoundHistory {

    private final List<Integer> positions;

    private RoundHistory(List<Integer> positions) {
        this.positions = positions;
    }

    public static RoundHistory from(List<Integer> positions) {
        return new RoundHistory(positions);
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(positions);
    }

}
