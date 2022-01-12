package racingcar.ui;

import racingcar.domain.RoundHistory;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.Constants.*;

public class ResultView {
    public static void printResult(List<RoundHistory> histories, List<String> winners) {
        String historyStr = historyToStr(histories);
        String winnersStr = winnersToStr(winners);

        System.out.println(GUIDE_RESULT_STR);
        System.out.println(historyStr);
        System.out.println(winnersStr + GUIDE_WINNER_STR);
    }

    private static String winnersToStr(List<String> winners) {
        return String.join(", ", winners);
    }

    private static String historyToStr(List<RoundHistory> histories) {
        return histories.stream()
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
