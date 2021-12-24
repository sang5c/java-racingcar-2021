package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class OperatorTest {

    @DisplayName("연산자는 문자열을 받아 연산자 객체를 반환한다.")
    @ParameterizedTest(name = "\"{0}\"를 받으면 {1}를 반환한다.")
    @CsvSource({"+, PLUS", "-, MINUS", "*, MULTIPLY", "/, DIVIDE"})
    void ofString(String symbol, Operator operator) {
        assertThat(Operator.ofString(symbol)).isEqualTo(operator);
    }

    @DisplayName("+-*/에 해당하지 않는 경우 IllegalArgumentException이 발생한다.")
    @Test
    void invalidSymbol() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.ofString("("));
    }

    @DisplayName("더하기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, 3", "3, 4, 7", "8, 0, 8"})
    void plus(int left, int right, int expected) {
        assertThat(Operator.PLUS.calculate(left, right)).isEqualTo(expected);
    }

    @DisplayName("빼기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, -1", "10, 2, 8", "5, 5, 0"})
    void minus(int left, int right, int expected) {
        assertThat(Operator.MINUS.calculate(left, right)).isEqualTo(expected);
    }

    @DisplayName("곱하기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"1, 2, 2", "4, 7, 28", "9, 0, 0"})
    void multiply(int left, int right, int expected) {
        assertThat(Operator.MULTIPLY.calculate(left, right)).isEqualTo(expected);
    }

    @DisplayName("나누기는")
    @ParameterizedTest(name = "{0}, {1}을 받으면 {2}을 반환한다.")
    @CsvSource({"5, 1, 5", "6, 2, 3", "10, 5, 2"})
    void divide(int left, int right, int expected) {
        assertThat(Operator.DIVIDE.calculate(left, right)).isEqualTo(expected);
    }

    @DisplayName("나누기는 두 번째 인자 값으로 0을 받으면 IllegalArgumentException이 발생한다")
    @Test
    void divideZero() {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.DIVIDE.calculate(2, 0));
    }

}
