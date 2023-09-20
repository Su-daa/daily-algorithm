package fc0920;

import java.util.HashMap;
import java.util.Map;

public class 펠린드롬 {
    public static int solution(String s) {
        int answer = 0;
        Map<Character, Integer> sMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        int MAX = 0;
        for (char key : sMap.keySet()) {
            if (sMap.get(key) % 2 == 0) {
                answer = answer + sMap.get(key);
            } else if (sMap.get(key) % 2 == 1) {
                if (MAX < sMap.get(key)) {
                    MAX = sMap.get(key);
                }
            }
        }
        answer = answer + MAX;
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcbbbccaaeee"));
        System.out.println(solution("aabbccddee"));
        System.out.println(solution("fgfgabtetaaaetytceefcecekefefkccckbsgaafffg"));
        System.out.println(solution("aabcefagcefbcabbcc"));
        System.out.println(solution("abcbbbccaa"));
    }
}
