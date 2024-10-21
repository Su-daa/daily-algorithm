package programmers;

import java.util.Stack;

public class p_64061 {
    public static void main(String[] args) {
    }
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        A: for (int n : moves) {
            for (int i = 0; i < board.length; i++) {
                if (board[i][n-1] != 0) {
                    if (!stack.isEmpty() && stack.peek() == board[i][n-1]) {
                        stack.pop();
                        board[i][n - 1] = 0;
                        answer += 2;
                    }else {
                        stack.push(board[i][n-1]);
                        board[i][n - 1] = 0;
                    }
                    continue A;
                }
            }
        }
        return answer;
    }
    public static int solutionBook(int[][] board, int[] moves) {
        // 스택 배열로 사용하기
        // 스택은 FILO 이므로 가장 밑에 있는 인형부터 푸시해야함.
        Stack<Integer>[] lanes = new Stack[board.length];
        for (int i = 0; i < lanes.length; i++) {
            lanes[i] = new Stack<>();
        }
        // board를 스택으로 변경하기
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] > 0) {
                    lanes[j].push(board[i][j]);
                }
            }
        }

        Stack<Integer> bucket = new Stack<>();
        int answer = 0;
        for (int move : moves) {
            if (!lanes[move - 1].isEmpty()) {
                int doll = lanes[move].pop();
                if (!bucket.isEmpty() && bucket.peek() == doll) {
                    bucket.pop();
                    answer += 2;
                }
            }
        }
        return answer;
    }
}
