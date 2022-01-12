package racingcar.domain.history;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundHistories {

    private final List<RoundHistory> histories = new ArrayList<>();

    public void add(RoundHistory roundHistory) {
        this.histories.add(roundHistory);
    }

    public FinalRoundHistory getFinalRoundHistory() {
        return FinalRoundHistory.from(histories);
    }

    public List<RoundHistory> getAll() {
        return Collections.unmodifiableList(histories);
    }

}
