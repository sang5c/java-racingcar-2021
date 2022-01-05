package racingcar.domain;

public class CountOfCars {

    private static final String ERROR_MIN_COUNT = "racing car는 1개 이상 필요합니다";
    private static final int MIN_COUNT = 1;
    private final int count;

    public CountOfCars(int count) {
        validate(count);
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    private void validate(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_COUNT);
        }
    }

}
