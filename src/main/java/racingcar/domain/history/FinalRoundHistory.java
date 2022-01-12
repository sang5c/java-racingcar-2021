package racingcar.domain.history;

import java.util.List;
import java.util.stream.Collectors;

public class FinalRoundHistory {

    private final RoundHistory finalRoundHistory;
    private final int maxPosition;
    private final Winners winners;

    private FinalRoundHistory(List<RoundHistory> histories) {
        this.finalRoundHistory = histories.get(lastIndex(histories));
        this.maxPosition = getMaxPosition();
        this.winners = findWinners();
    }

    private int lastIndex(List<RoundHistory> histories) {
        return histories.size() - 1;
    }

    public static FinalRoundHistory from(List<RoundHistory> histories) {
        return new FinalRoundHistory(histories);
    }

    public Winners getWinners() {
        return this.winners;
    }

    private Winners findWinners() {
        List<String> winners = finalRoundHistory.getMoveResults()
                .stream()
                .filter(r -> r.isWinner(maxPosition))
                .map(MoveResult::getName)
                .collect(Collectors.toList());

        return Winners.from(winners);
    }

    private int getMaxPosition() {
        return finalRoundHistory.getMoveResults()
                .stream()
                .map(MoveResult::getPosition)
                .max(Integer::compare)
                .orElseThrow();
    }

}
