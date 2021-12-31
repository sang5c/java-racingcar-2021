package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberTest {

    @DisplayName("문자열을 받아 객체를 생성한다")
    @Test
    void ofString() {
        assertThat(Number.ofString("1")).isNotNull();
    }

    @DisplayName("연산자와 숫자를 받아 계산을 실행하면 계산된 결과를 반환한다.")
    @Test
    void calculate() {
        Number number1 = Number.ofString("10");
        Number number2 = Number.ofString("2");

        assertThat(number1.calculate(Operator.MULTIPLY, number2)).isEqualTo(Number.of(20));
    }

}
