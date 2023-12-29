package fc1228;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

//과제 진행하기
public class pg176962 {
    public static void main(String[] args) {
        String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};

        Arrays.sort(plans, Comparator.comparing(o -> o[1]));

        Stack<Task> stack = new Stack<>();
        for(int i = 0; i < plans.length; i++) {
            String[] str = plans[i][1].split(":");
            int h = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int start = (h * 60) + m;

            String[] str1 = plans[i+1][1].split(":");
            int h1 = Integer.parseInt(str[0]);
            int m1 = Integer.parseInt(str[1]);
            int start1 = (h * 60) + m;

        }


    }

    class Task {
        private String subject;
        private int remainTime;

        public Task(String subject, int remainTime) {
            this.subject = subject;
            this.remainTime = remainTime;
        }
    }
}
