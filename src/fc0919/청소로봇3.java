package fc0919;

import java.util.Arrays;

public class 청소로봇3 {
    public static int[] solution(int[][] board, int k) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int time = 0, r = 0, c = 0, d = 1;

        while (time < k) {
            time++;
            int nr = r + dr[d];
            int nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= board.length || nc >= board.length || board[nr][nc] == 1) {
                //회전
                d = (d + 1) % 4;
                continue;
            }
            r = nr;
            c = nc;
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(solution(arr3, 25)));

    }
}
