package fc0921;

import java.util.Stack;

public class 괄호문자제거 {
    public static String solution(String str){
        Stack<Character> stack = new Stack<>();
        for (char c :str.toCharArray()) {
            if (c == ')') {
                while(true) {
                    if (stack.pop() == '(') break;
                }
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
        System.out.println(solution("(A(BC)D)EF(G(H)(IJ)K)LM(N)"));
    }
}
