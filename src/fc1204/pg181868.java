package fc1204;

import java.util.ArrayList;
import java.util.List;

public class pg181868 {

    public static void main(String[] args) {
        String str = "  programmas";
        String[] s = str.split(" ");
        String[] answer = {};

        List<String> answerList = new ArrayList<>();


        for (String string : s) {
            if (!string.isBlank()) {
                answerList.add(string);
            }
        }

        String[] array = answerList.toArray(new String[0]);
    }
}
