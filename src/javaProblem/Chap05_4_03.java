package javaProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Chap05_4_03 {
    public static void main(String[] args) {


    }

    public static int[] solution(int[] numbers) {
        int[] answer = {};
        ArrayList<Integer> answerList = new ArrayList<>();
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                answerList.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] integers = answerList.stream().distinct().toArray(Integer[]::new);
        Arrays.sort(integers);
        answer = Arrays.stream(integers).mapToInt(Integer::intValue).toArray();
        return answer;
    }
}
