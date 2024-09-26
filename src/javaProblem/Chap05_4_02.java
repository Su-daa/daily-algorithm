package javaProblem;

import java.util.Arrays;
import java.util.Collections;

public class Chap05_4_02 {
    public static void main(String[] args) {

    }

    public static int[] solution(int[] array) {
        Integer[] result = Arrays.stream(array).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder());
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
