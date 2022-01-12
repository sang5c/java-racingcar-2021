package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.history.MoveResult;
import racingcar.domain.history.RoundHistory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RoundHistoryTest {

    @DisplayName("from 메소드는 RoundHistory 객체를 반환한다")
    @Test
    void from() {
        RoundHistory roundHistory = RoundHistory.from(List.of(new MoveResult("pobi", 1)));
        assertThat(roundHistory).isNotNull();
    }

    @DisplayName("getPositions 메소드는 저장된 포지션 목록을 반환한다")
    @Test
    void getPositions() {
        List<MoveResult> history = List.of(new MoveResult("pobi", 1));
        RoundHistory roundHistory = RoundHistory.from(history);
        assertThat(roundHistory.getMoveResults()).isEqualTo(history);
    }

}
