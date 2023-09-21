package fc0921;

import java.util.Stack;

public class 연속된문자지우기 {
    public static String solution(String s){
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty()&&stack.peek() == c) {
                stack.pop();
            }
            else {
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(solution("acbbcaa"));
        System.out.println(solution("bacccaba"));
        System.out.println(solution("aabaababbaa"));
        System.out.println(solution("bcaacccbaabccabbaa"));
        System.out.println(solution("cacaabbc"));
    }
}
