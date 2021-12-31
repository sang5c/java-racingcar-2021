package racingcar;

import racingcar.domain.Car;
import racingcar.ui.InputView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int numberOfCars = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new Car());
        }

        for (int i = 0; i < tryCount; i++) {
            for (int k = 0; k < numberOfCars; k++) {
                cars.get(k).move();
            }
        }
    }

}
