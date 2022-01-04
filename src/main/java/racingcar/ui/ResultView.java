package racingcar.ui;

import racingcar.dto.RoundHistory;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    private static final String LINE_FEED_FOR_POSITION = "\n";
    private static final String LINE_FEED_FOR_ROUND = "\n\n";
    private static final String POSITION_STR = "-";
    public static final String GUIDE_RESULT_STR = "실행 결과";

    public static void printResult(List<RoundHistory> histories) {
        String historyStr = histories.stream()
                .map(ResultView::convertToStr)
                .collect(Collectors.joining(LINE_FEED_FOR_ROUND));

        System.out.println(GUIDE_RESULT_STR);
        System.out.println(historyStr);
    }

    private static String convertToStr(RoundHistory history) {
        return history.getPositions()
                .stream()
                .map(POSITION_STR::repeat)
                .collect(Collectors.joining(LINE_FEED_FOR_POSITION));
    }

}
