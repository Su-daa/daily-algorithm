package fc0920;

import java.util.HashMap;
import java.util.Map;

public class 학급회장 {

    public static char solution(String s){
        int max = Integer.MIN_VALUE;
        char answer=' ';
        Map<Character, Integer> votes = new HashMap<>();
        for (char vote : s.toCharArray()) {
            votes.put(vote, votes.getOrDefault(vote, 0) + 1);
        }

        for (char key : votes.keySet()) {
            if (votes.get(key) > max) {
                max = votes.get(key);
                answer = key;
            }
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(solution("BACBACCACCBDEDE"));
        System.out.println(solution("AAAAABBCCDDDD"));
        System.out.println(solution("AABBCCDDEEABCB"));
    }
}
