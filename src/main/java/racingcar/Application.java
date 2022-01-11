package racingcar;

import racingcar.domain.Cars;
import racingcar.domain.MoveResult;
import racingcar.domain.RoundHistory;
import racingcar.domain.TryCount;
import racingcar.ui.InputView;
import racingcar.ui.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        String carNames = InputView.inputCarNames();
        TryCount tryCount = new TryCount(InputView.inputTryCount());

        Cars cars = Cars.from(carNames);

        List<RoundHistory> histories = new ArrayList<>();
        while (tryCount.canTry()) {
            tryCount.decrease();
            histories.add(cars.moveAll());
        }
        List<String> winners = findWinners(histories);
        ResultView.printResult(histories, winners);
    }

    private static List<String> findWinners(List<RoundHistory> histories) {
        RoundHistory finalRoundHistory = getFinalRoundHistory(histories);
        List<MoveResult> moveResults = finalRoundHistory.getMoveResults();
        int winnerPosition = getWinnerPosition(moveResults);
        return moveResults.stream()
                .filter(r -> r.getPosition() == winnerPosition)
                .map(MoveResult::getName)
                .collect(Collectors.toList());
    }

    private static RoundHistory getFinalRoundHistory(List<RoundHistory> histories) {
        return histories.get(histories.size() - 1);
    }

    private static int getWinnerPosition(List<MoveResult> moveResults) {
        return moveResults.stream()
                .max(Comparator.comparing(MoveResult::getPosition))
                .orElseThrow()
                .getPosition();
    }

}
