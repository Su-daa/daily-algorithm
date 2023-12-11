package fc1208;

import java.util.*;

public class pg120812 {
    public static void main(String[] args) {
        int[] array = {1,2,2,2,3,3,3};
        int answer = 0;
        int maxCount = 0;

        Map<Integer, Integer> map = new HashMap<>();


        for(int number : array) {
            int count = map.getOrDefault(number, 0) + 1;

            if(count > maxCount) {
                maxCount = count;
                answer = number;
            }

            else if(count == maxCount) {
                answer = -1;
            }

            map.put(number, count);
        }


        System.out.println(answer);
    }
}
