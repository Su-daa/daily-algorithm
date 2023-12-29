package fc1226;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//요격 시스템
public class pg181188 {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};

        Arrays.sort(targets,((Comparator.comparingInt(o -> o[1]))));
        Stack<Integer> stack = new Stack<>();

        stack.push(targets[0][1]);
        for (int i = 1; i < targets.length; i++) {
            if (stack.peek() <= targets[i][0]) {
                stack.push(targets[i][1]);
            }
        }
        System.out.println(stack.size());
    }
}
