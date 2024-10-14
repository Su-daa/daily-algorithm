package programmers;

import java.util.Stack;

public class p_42584 {
    public int[] solution(int[] prices) {
        int[] answer = {};

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            if (stack.isEmpty()) {
                stack.push(prices[i]);
            }
        }

        return answer;
    }
}
