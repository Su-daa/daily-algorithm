package test.kt1019;

import java.util.ArrayDeque;
import java.util.HashMap;

public class P_10 { // 괄호 회전하기
    public static int solution(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '('); // key, value
        map.put('}', '{');
        map.put(']', '[');

        int n = s.length(); // 문자열 길이는 length() 내장함수 이용
        s += s; // 문자열 두번 나오도록 -> 회전한다
        int answer = 0;

        A: for (int i = 0; i < n; i++) {
            ArrayDeque<Character> stack = new ArrayDeque<>();
            for (int j = i; j < i + n; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                }
                else {
                    if (stack.isEmpty() || !stack.pop().equals(map.get(c))) {
                        continue A;
                    }
                }
            }
            if (stack.isEmpty()) {
                answer++;
            }
        }
        return answer;
    }
}
