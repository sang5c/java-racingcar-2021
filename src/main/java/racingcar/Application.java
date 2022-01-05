package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.CountOfCars;
import racingcar.domain.TryCount;
import racingcar.dto.RoundHistory;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        CountOfCars numberOfCars = new CountOfCars(InputView.inputCarCount());
        TryCount tryCount = new TryCount(InputView.inputTryCount());

        Cars cars = Cars.from(numberOfCars);

        List<RoundHistory> histories = new ArrayList<>();
        while (tryCount.canTry()) {
            tryCount.decrease();
            histories.add(cars.moveAll());
        }

        ResultView.printResult(histories);
    }

}
