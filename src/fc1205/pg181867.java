package fc1205;

import java.util.ArrayList;
import java.util.List;

//x 사이의 개수
public class pg181867 {
    public static void main(String[] args) {
        int[] answer = {};
        String myString = "xabcxdefxghix";

        String[] strings = myString.split("x",myString.length());

        List<Integer> answers = new ArrayList<>();
        for (String str : strings) {
            System.out.println("str = " + str);
            answers.add(str.length());
        }

        System.out.println("answers = " + answers);
    }
}
