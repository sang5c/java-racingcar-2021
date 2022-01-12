package racingcar.domain.history;

import java.util.Collections;
import java.util.List;

public class Winners {
    private final List<String> winners;

    private Winners(List<String> winners) {
        this.winners = winners;
    }

    public static Winners from(List<String> winners) {
        return new Winners(winners);
    }

    public static Winners findWinners(RoundHistories histories) {
        FinalRoundHistory finalRoundHistory = histories.getFinalRoundHistory();
        return finalRoundHistory.getWinners();
    }

    public List<String> getAll() {
        return Collections.unmodifiableList(winners);
    }

}
