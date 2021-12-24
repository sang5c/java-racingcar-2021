package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @DisplayName("계산 기능")
    @ParameterizedTest(name = "{0} {1} {2} == {3}")
    @CsvSource({"1, +, 2, 3", "4, -, 2, 2", "5, *, 2, 10", "6, /, 3, 2"})
    void calculate(int left, String symbol, int right, int expected) {
        assertThat(Calculator.calculate(symbol, left, right)).isEqualTo(expected);
    }

}
