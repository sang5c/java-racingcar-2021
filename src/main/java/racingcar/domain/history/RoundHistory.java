package racingcar.domain.history;

import java.util.Collections;
import java.util.List;

public class RoundHistory {

    private final List<MoveResult> moveResults;

    private RoundHistory(List<MoveResult> moveResults) {
        this.moveResults = moveResults;
    }

    public static RoundHistory from(List<MoveResult> moveResults) {
        return new RoundHistory(moveResults);
    }

    public List<MoveResult> getMoveResults() {
        return Collections.unmodifiableList(moveResults);
    }

}
