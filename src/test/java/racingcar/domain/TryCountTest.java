package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TryCountTest {

    @DisplayName("TryCount는 0이하로 생성하면 에러가 발생한다")
    @Test
    void create() {
        assertThatThrownBy(() -> new TryCount(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("canTry 메소드는 count가 1 이상이면 true를 반환한다")
    @Test
    void tryCount() {
        TryCount tryCount = new TryCount(2);
        assertThat(tryCount.canTry()).isTrue();
    }

    @DisplayName("canTry 메소드는 count가 0이면 false를 반환한다")
    @Test
    void tryCountFalse() {
        TryCount tryCount = new TryCount(1);
        tryCount.decrease();

        assertThat(tryCount.canTry()).isFalse();
    }
}
