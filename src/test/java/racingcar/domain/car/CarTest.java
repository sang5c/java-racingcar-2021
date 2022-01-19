package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.move.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class CarTest {

    @DisplayName("자동차를 생성하라")
    @Test
    void create() {
        Car car = new Car("pobi", new RandomMoveStrategy());
        assertThat(car).isNotNull();
    }

    @DisplayName("비어있거나 5자 이상의 이름을 전달하면 에러가 발생한다")
    @Test
    void invalidName() {
        assertThatThrownBy(() -> new Car("", () -> true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("asdfge", () -> true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("성공 전략 주입시 move 메소드를 호출하면 1 증가한 position을 반환한다")
    @Test
    void move() {
        Car car = new Car("jason", () -> true);
        assertAll(
                () -> assertThat(car.move().getPosition()).isEqualTo(1),
                () -> assertThat(car.move().getPosition()).isEqualTo(2),
                () -> assertThat(car.move().getPosition()).isEqualTo(3)
        );
    }

}
