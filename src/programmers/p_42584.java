package programmers;

import java.util.Stack;

public class p_42584 {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for (int i = 0; i < n; i++) {
            // 가격이 떨어진 때
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }
        // 마지막 까지 가격이 떨어지지 않은 경우
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - j - 1;
        }
        return answer;
    }
}
