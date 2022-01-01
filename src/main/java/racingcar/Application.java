package racingcar;

import racingcar.domain.Car;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

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

        List<List<Integer>> histories = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            List<Integer> roundHistory = new ArrayList<>();
            for (int k = 0; k < numberOfCars; k++) {
                roundHistory.add(cars.get(k).move());
            }
            histories.add(roundHistory);
        }

        ResultView.printResult(histories);
    }


}
