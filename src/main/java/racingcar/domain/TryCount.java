package racingcar.domain;

public class TryCount {

    private static final String ERROR_MIN_COUNT = "시도 횟수는 1 이상만 가능합니다";
    private static final int MIN_COUNT = 1;

    private int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_COUNT);
        }
    }

    public boolean canTry() {
        return count >= MIN_COUNT;
    }

    public void decrease() {
        if (canTry()) {
            this.count--;
        }
    }

}
