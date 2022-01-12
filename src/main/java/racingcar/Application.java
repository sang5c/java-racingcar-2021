package racingcar;

import racingcar.domain.car.Cars;
import racingcar.domain.history.RoundHistories;
import racingcar.domain.TryCount;
import racingcar.domain.history.Winners;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        TryCount tryCount = new TryCount(InputView.inputTryCount());

        Cars cars = Cars.from(carNames);

        RoundHistories histories = new RoundHistories();
        while (tryCount.canTry()) {
            tryCount.decrease();
            histories.add(cars.moveAll());
        }
        Winners winners = Winners.findWinners(histories);
        ResultView.printResult(histories, winners);
    }

}
