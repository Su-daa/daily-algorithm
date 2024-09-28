package programmers;

import java.util.ArrayList;

public class p_42840 {
    public int[] solution(int[] answers) {
        int[][] patterns={
                {1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}
        };

        int[] hit = new int[3]; //맞힌 갯수
        for (int i = 0; i < hit.length; i++) {
            for (int j = 0; j < answers.length; j++) {
                if(patterns[i][j%patterns[i].length]==answers[j]){
                    hit[i]++;
                }
            }
        }

        int max = Math.max(hit[0], Math.max(hit[1], hit[2]));
        ArrayList<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < hit.length; i++) {
            if (max == hit[i]) {
                answerList.add(i + 1);
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }
}
