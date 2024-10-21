package test.kt1019;

import java.util.ArrayDeque;
import java.util.Arrays;

public class P_17 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        ArrayDeque<String> cardDeque1 = new ArrayDeque<>(Arrays.asList(cards1));
        ArrayDeque<String> cardDeque2 = new ArrayDeque<>(Arrays.asList(cards2));
        ArrayDeque<String> goalDeque = new ArrayDeque<>(Arrays.asList(goal));

        while (!goalDeque.isEmpty()) {
            if (!cardDeque1.isEmpty() && cardDeque1.peekFirst().equals(goalDeque.peekFirst())) {
                cardDeque1.pollFirst();
                goalDeque.pollFirst();
            } else if (!cardDeque2.isEmpty() && cardDeque2.peekFirst().equals(goalDeque.peekFirst())) {
                cardDeque2.pollFirst();
                goalDeque.pollFirst();
            } else {
                break;
            }
        }

        return goalDeque.isEmpty() ? "Yes" : "No";
    }
}
