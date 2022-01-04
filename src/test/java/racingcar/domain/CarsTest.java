package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.RoundHistory;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @DisplayName("Car 숫자를 받아 Cars를 생성한다")
    @Test
    void from() {
        Cars cars = Cars.from(5);
        assertThat(cars).isNotNull();
    }

    @DisplayName("moveAll 메소드는 Car 수 크기의 히스토리 list를 반환한다.")
    @Test
    void moveAll() {
        int numberOfCars = 5;
        Cars cars = Cars.from(numberOfCars);
        RoundHistory roundHistory = cars.moveAll();
        assertThat(roundHistory.getPositions().size()).isEqualTo(numberOfCars);
    }

}
