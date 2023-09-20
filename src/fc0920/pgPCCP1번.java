package fc0920;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pgPCCP1번 {
    public String solution(String input_string) {
        String answer = "";
        Map<Character, Integer> alphabetMap = new HashMap<>();

        alphabetMap.put(input_string.charAt(0),1);
        for (int i = 1; i < input_string.length(); i++) {
            if (input_string.charAt(i - 1) != input_string.charAt(i)) {
                alphabetMap.put(input_string.charAt(i), alphabetMap.getOrDefault(input_string.charAt(i), 0) + 1);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char key : alphabetMap.keySet()) {
            if(alphabetMap.get(key)>=2){
                sb.append(key);
            }
        }
        answer=sb.toString();
        if (answer.equals("")) {
            return "N";
        }

        char[] tmp = answer.toCharArray();
        Arrays.sort(tmp);
        answer = String.valueOf(tmp);
        return answer;
    }
}
