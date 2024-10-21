package test.kt1019;

import java.util.Stack;

public class P_11 { // 짝지어 제거하기
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
