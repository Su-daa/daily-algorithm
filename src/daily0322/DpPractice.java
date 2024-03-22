package daily0322;

import java.util.*;

public class DpPractice {
    private static Map<Integer, Integer> map;

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int result = fibonacci(n - 1) + fibonacci(n - 2);
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        map = new HashMap<>();

        System.out.println(fibonacci(10));
    }
}
