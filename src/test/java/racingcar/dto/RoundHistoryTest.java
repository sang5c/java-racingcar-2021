package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RoundHistoryTest {

    @DisplayName("from 메소드는 RoundHistory 객체를 반환한다")
    @Test
    void from() {
        assertThat(RoundHistory.from(List.of(1, 2, 3, 4, 5))).isNotNull();
    }

    @DisplayName("getPositions 메소드는 저장된 포지션 목록을 반환한다")
    @Test
    void getPositions() {
        List<Integer> positions = List.of(1, 2, 3, 4, 5);
        RoundHistory roundHistory = RoundHistory.from(positions);
        assertThat(roundHistory.getPositions()).isEqualTo(positions);
    }

}
