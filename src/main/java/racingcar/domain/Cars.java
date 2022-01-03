package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final RandomMoveStrategy DEFAULT_MOVE_STRATEGY = new RandomMoveStrategy();

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(int numberOfCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car(DEFAULT_MOVE_STRATEGY));
        }
        return new Cars(cars);
    }

    public List<Integer> moveAll() {
        return cars.stream()
                .map(Car::move)
                .collect(Collectors.toList());
    }

}
