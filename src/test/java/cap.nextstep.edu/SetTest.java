package cap.nextstep.edu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인하는 학습테스트를 구현한다.")
    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인하는 학습테스트를 구현.")
    @ParameterizedTest(name = "numbers는 {0}을 포함한다")
    @ValueSource(ints = {1, 2, 3})
    void contains(int value) {
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("1, 2, 3 값은 contains 메소드 실행결과 true, 4, 5 값을 넣으면 false 가 반환되는 테스트를 하나의 Test Case로 구현한다.")
    @ParameterizedTest(name = "numbers가 {0}을 포함 여부는 {1} 이다")
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    void containsFalse(int value, boolean expected) {
        assertThat(numbers.contains(value)).isEqualTo(expected);
    }

}
