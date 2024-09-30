package programmers;

import java.util.Stack;

public class p_12909 {
    public static void main(String[] args) {
        so
    }
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
//                if(stack.isEmpty()){
//                    return false;
//                }
//                if (stack.peek() == '(') {
//                    stack.pop();
//                } else {
//                    return false;
//                }
                if (stack.empty() || stack.pop() == ')') {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}
