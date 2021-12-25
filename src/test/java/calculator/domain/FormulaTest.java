package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FormulaTest {

    @DisplayName("문자열을 통해 계산식을 생성한다.")
    @Test
    void fromString() {
        assertThat(Formula.from("1 + 2 - 3")).isNotNull();
    }

    @DisplayName("계산식을 실행하면 계산된 결과를 반환한다.")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource({"1 + 2 - 3, 0", "2 + 3 * 4 / 2, 10"})
    void calculate(String str, int expected) {
        Formula formula = Formula.from(str);
        assertThat(formula.execute()).isEqualTo(expected);
    }

}
