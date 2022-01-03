package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @DisplayName("자동차를 생성하라")
    @Test
    void create() {
        Car car = new Car(new RandomMoveStrategy());
        assertThat(car).isNotNull();
    }

    @DisplayName("성공 전략 주입시 move 메소드를 호출하면 1 증가한 position을 반환한다")
    @Test
    void move() {
        Car car = new Car(() -> true);
        assertAll(
                () -> assertThat(car.move()).isEqualTo(1),
                () -> assertThat(car.move()).isEqualTo(2),
                () -> assertThat(car.move()).isEqualTo(3)
        );
    }

}
