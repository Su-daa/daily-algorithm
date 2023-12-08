package fc1207;

import java.util.ArrayList;
import java.util.List;

//ox 퀴즈
public class pg120907 {
    public static void main(String[] args) {
        String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"};
        String[] s1 = {};
        List<String> answer = new ArrayList<>();

        for (String s : quiz) {
            s1 = s.split(" ");
            if(s1[1].equals("+")){
                if(Integer.parseInt(s1[0])+Integer.parseInt(s1[2])==Integer.parseInt(s1[4])){
                    answer.add("O");
                }else {
                    answer.add("X");
                }
            }


            if(s1[1].equals("-")){
                if(Integer.parseInt(s1[0])-Integer.parseInt(s1[2])==Integer.parseInt(s1[4])){
                    answer.add("O");
                }else {
                    answer.add("X");
                }
            }
        }
    }
}
