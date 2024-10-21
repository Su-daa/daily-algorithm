package test.kt1019;

import java.util.Stack;

public class P_12 { // 주식 가격
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // 맨 첫번째 인덱스는 미리 집어 넣기

        for (int i = 1; i < n; i++) {
            // 스택이 비어있지 않고, 현재 가격이 이전 가격보다 작으면 -> 가격이 떨어졋다
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        // 남아있는 것들은 끝까지 가격 안떨어 졋기 때문에 들어온 시간부터 끝까지의 시간이 정답
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = n - 1 - j;
        }
        return answer;
    }
}
