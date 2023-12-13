package fc1212;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class pg176963 {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }

        List<Integer> answer = new ArrayList<>();

        for (String[] p : photo) {
            int count=0;
            for (int i = 0; i < p.length; i++) {
                count += map.getOrDefault(p[i],0);
            }
            answer.add(count);
        }

        for (Integer i : answer) {
            System.out.println(i);
        }
    }
}
