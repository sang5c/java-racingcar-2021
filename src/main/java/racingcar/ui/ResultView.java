package racingcar.ui;

import racingcar.dto.MoveResult;
import racingcar.dto.RoundHistory;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.Constants.*;

public class ResultView {

    public static void printResult(List<RoundHistory> histories) {
        String historyStr = histories.stream()
                .map(ResultView::convertToStr)
                .collect(Collectors.joining(LINE_FEED_FOR_ROUND));

        System.out.println(GUIDE_RESULT_STR);
        System.out.println(historyStr);
    }

    private static String convertToStr(RoundHistory history) {
        List<MoveResult> moveResults = history.getMoveResults();
        return moveResults.stream()
                .map(moveResult -> moveResult.getName() + COLON + POSITION_STR.repeat(moveResult.getPosition()))
                .collect(Collectors.joining(LINE_FEED_FOR_POSITION));
    }

}
