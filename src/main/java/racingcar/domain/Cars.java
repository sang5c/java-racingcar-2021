package racingcar.domain;

import racingcar.dto.RoundHistory;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final String NAME_SPLIT_REGEX = ",";
    private static final String ERROR_INVALID_CAR_NAMES = "자동차 이름이 비어있습니다.";
    private static final RandomMoveStrategy DEFAULT_MOVE_STRATEGY = new RandomMoveStrategy();

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(String str) {
        validate(str);
        List<String> carNames = List.of(str.split(NAME_SPLIT_REGEX));
        List<Car> cars = carNames.stream()
                .map(name -> new Car(name, DEFAULT_MOVE_STRATEGY))
                .collect(Collectors.toList());
        return new Cars(cars);
    }

    private static void validate(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAMES);
        }
    }

    public RoundHistory moveAll() {
        List<Integer> positions = cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

        return RoundHistory.from(positions);
    }

}
