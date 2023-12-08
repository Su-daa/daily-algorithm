package fc1207;

import java.util.*;

//한 번만 등장한 문자
public class pg120896 {
    public static void main(String[] args) {
        String s = "abcabcadc";
//
//        List<String> answer = new ArrayList<>();
//        String[] split = s.split("");
//        Arrays.sort(split);
//
//        for (int i = 0; i < split.length; i++) {
//            answer.add(split[i]);
//
//            if (!answer.contains(String.valueOf(split[i]))) {
//            }
//        }
//        answer.sort(Comparator.naturalOrder());
//        StringBuilder sb = new StringBuilder();
//        for (String c : answer) {
//            sb.append(c);
//        }
//        System.out.println(sb.toString());
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for (Character c : map.keySet()) {
            if (map.get(c)==1){
                answer.append(c);
            }
        }

    }
}
