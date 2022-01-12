package racingcar.ui;

import racingcar.domain.history.RoundHistories;
import racingcar.domain.history.RoundHistory;
import racingcar.domain.history.Winners;

import java.util.stream.Collectors;

import static racingcar.ui.Constants.*;

public class ResultView {
    public static void printResult(RoundHistories histories, Winners winners) {
        String historyStr = historyToStr(histories);
        String winnersStr = winnersToStr(winners);

        System.out.println(GUIDE_RESULT_STR);
        System.out.println(historyStr);
        System.out.println(winnersStr + GUIDE_WINNER_STR);
    }

    private static String winnersToStr(Winners winners) {
        return String.join(", ", winners.getAll());
    }

    private static String historyToStr(RoundHistories histories) {
        return histories.getAll()
                .stream()
                .map(ResultView::convertToStr)
                .collect(Collectors.joining(LINE_FEED_FOR_ROUND));
    }

    private static String convertToStr(RoundHistory history) {
        return history.getMoveResults()
                .stream()
                .map(moveResult -> moveResult.getName() + COLON + POSITION_STR.repeat(moveResult.getPosition()))
                .collect(Collectors.joining(LINE_FEED_FOR_POSITION));
    }

}
