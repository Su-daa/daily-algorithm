package fc1207;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//한 번만 등장한 문자
public class pg120896 {
    public static void main(String[] args) {
        String s = "abcabcadc";
        List<String> answer = new ArrayList<>();
        String[] split = s.split("");
        Arrays.sort(split);

        for (int i = 0; i < split.length; i++) {
            answer.add(split[i]);

            if (!answer.contains(String.valueOf(split[i]))) {
            }
        }
        answer.sort(Comparator.naturalOrder());
        StringBuilder sb = new StringBuilder();
        for (String c : answer) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }
}
