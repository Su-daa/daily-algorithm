package test.kt1019;

import java.util.Stack;

public class P_13 {
    public int solution(int[][] board, int[] moves) {
        // 각 열을 스택으로 바꿔준다
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            // 스택 배열 하나씩 초기화 시켜주기
            lanes[i] = new Stack<>();
        }

        // 배열 역순으로 -> 맨 아래있는거일수록 행 숫자가 커지니까
        for (int i = board.length; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        // 인형 뽑은 결과값을 담는 bucket 생성
        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) { // 해당 열에 인형이 있으면
                int doll = lanes[move - 1].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                } else {
                    bucket.push(doll);
                }
            }
        }

        return answer;
    }
}
