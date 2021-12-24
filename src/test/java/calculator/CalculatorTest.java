package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    @DisplayName("더하기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, 3", "3, 4, 7", "8, 0, 8"})
    void add(int left, int right, int expected) {
        assertThat(Calculator.calculate("+", left, right)).isEqualTo(expected);
    }

    @DisplayName("빼기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, -1", "10, 2, 8", "5, 5, 0"})
    void minus(int left, int right, int expected) {
        assertThat(Calculator.calculate("-", left, right)).isEqualTo(expected);
    }

    @DisplayName("곱하기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, 2", "4, 7, 28", "9, 0, 0"})
    void multiply(int left, int right, int expected) {
        assertThat(Calculator.calculate("*", left, right)).isEqualTo(expected);
    }

    @DisplayName("나누기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"5, 1, 5", "6, 2, 3", "10, 5, 2"})
    void divide(int left, int right, int expected) {
        assertThat(Calculator.calculate("/", left, right)).isEqualTo(expected);
    }

    @DisplayName("나누기는 두 번째 인자 값으로 0을 받으면 IllegalArgumentException이 발생한다")
    @Test
    void divideZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.calculate("/", 2, 0));
    }

}
