package fc0115;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class pg152996 {
    public static void main(String[] args) {
        long answer = 0;
        int[] weights = {100, 180, 360, 100, 270};

        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();
        for (int weight : weights) {
            double x = weight * 1.0;
            double y = weight * 1.0 / 2.0;
            double z = weight * 2.0 / 3.0;
            double w = weight * 3.0 / 4.0;

            if (map.containsKey(x)) {
                answer += map.get(x);
            }
            if (map.containsKey(y)) {
                answer += map.get(y);
            }
            if (map.containsKey(z)) {
                answer += map.get(z);
            }
            if (map.containsKey(w)) {
                answer += map.get(w);
            }
            map.put(weight * 1.0, map.getOrDefault(weight * 1.0, 0) + 1);
        }

    }
}
