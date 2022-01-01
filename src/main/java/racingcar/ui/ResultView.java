package racingcar.ui;

import java.util.List;

public class ResultView {

    private static final String LINE_FEED = "\n";
    private static final String POSITION_STR = "-";
    public static final String GUIDE_RESULT_STR = "실행 결과";

    public static void printResult(List<List<Integer>> histories) {
        StringBuilder historyBuilder = new StringBuilder();
        for (List<Integer> history : histories) {
            for (Integer position : history) {
                historyBuilder.append(POSITION_STR.repeat(position));
                historyBuilder.append(LINE_FEED);
            }
            historyBuilder.append(LINE_FEED);
        }

        System.out.println(GUIDE_RESULT_STR);
        System.out.println(historyBuilder);
    }
}
