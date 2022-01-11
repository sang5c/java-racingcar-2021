package racingcar.domain;

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
        List<String> carNames = splitNames(str);
        List<Car> cars = createCars(carNames);
        return new Cars(cars);
    }

    private static List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(name -> new Car(name, DEFAULT_MOVE_STRATEGY))
                .collect(Collectors.toList());
    }

    private static List<String> splitNames(String str) {
        return List.of(str.split(NAME_SPLIT_REGEX));
    }

    private static void validate(String str) {
        if (str.isBlank()) {
            throw new IllegalArgumentException(ERROR_INVALID_CAR_NAMES);
        }
    }

    public RoundHistory moveAll() {
        List<MoveResult> moveResults = cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());

        return RoundHistory.from(moveResults);
    }

}
