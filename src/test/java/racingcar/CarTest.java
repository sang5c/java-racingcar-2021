package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차를 생성하라")
    @Test
    void create() {
        Car car = new Car();
        assertThat(car).isNotNull();
    }

}
