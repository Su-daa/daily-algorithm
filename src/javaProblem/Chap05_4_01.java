package javaProblem;

import java.util.Arrays;

public class Chap05_4_01 {
    public static void main(String[] args) {
        int[] result = solution(new int[]{1, 2, 5, 4, 3});
        System.out.println("result.toString() = " + Arrays.toString(result));

    }

    public static int[] solution(int[] array) {
        Arrays.sort(array);
        return array;
    }
}
