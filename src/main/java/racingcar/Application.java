package racingcar;

import racingcar.domain.Cars;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int numberOfCars = InputView.inputCarCount();
        int tryCount = InputView.inputTryCount();

        Cars cars = Cars.from(numberOfCars);

        List<List<Integer>> histories = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            histories.add(cars.moveAll());
        }

        ResultView.printResult(histories);
    }

}
