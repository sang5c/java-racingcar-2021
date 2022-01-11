package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {

    private final String names = "pobi,crong,honux";

    @DisplayName("Car 이름 문자열을 받아 Cars를 생성한다")
    @Test
    void from() {
        Cars cars = Cars.from(names);
        assertThat(cars).isNotNull();
    }

    @DisplayName("moveAll 메소드는 Car 수 크기의 히스토리 list를 반환한다.")
    @Test
    void moveAll() {
        Cars cars = Cars.from(names);
        RoundHistory roundHistory = cars.moveAll();
        assertThat(roundHistory.getMoveResults().size()).isEqualTo(3);
    }

}
