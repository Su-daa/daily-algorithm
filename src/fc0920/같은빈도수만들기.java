package fc0920;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 같은빈도수만들기 {
    public static int[] solution(String s){
        int max = Integer.MIN_VALUE;
        int[] answer = new int[5];

        Map<Character, Integer> charMap = new HashMap<>();

        for(char c : s.toCharArray()){
            charMap.put(c, charMap.getOrDefault(c, 0)+1);
        }
        String tmp = "abcde";
        for(char key : tmp.toCharArray()){
            if(charMap.getOrDefault(key, 0) > max){
                max = charMap.getOrDefault(key, 0);
            }
        }
        for(int i = 0; i < tmp.length(); i++){
            answer[i] = max - charMap.getOrDefault(tmp.charAt(i), 0);
        }
        return answer;
    }

    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("aaabc")));
        System.out.println(Arrays.toString(solution("aabb")));
        System.out.println(Arrays.toString(solution("abcde")));
        System.out.println(Arrays.toString(solution("abcdeabc")));
        System.out.println(Arrays.toString(solution("abbccddee")));
    }
}
