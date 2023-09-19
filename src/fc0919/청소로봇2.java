package fc0919;

import java.util.Arrays;

public class 청소로봇2 {
    public static int[] solution(int n, String moves) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] dir = {'U', 'R', 'D', 'L'};
        int r = 0;
        int c = 0;

        for (char command : moves.toCharArray()) {
            int nr = 0, nc = 0;
            for (int i = 0; i < 4; i++) {
                if (command == dir[i]) {
                    nr= r + dr[i];
                    nc= c + dc[i];
                }
            }
            if (nr < 0 || nc < 0 || nr >= n || nc >= n) {
                continue;
            }
            r=nr;
            c=nc;
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(5, "RRRDDDUUUUUUL")));
        System.out.println(Arrays.toString(solution(7, "DDDRRRDDLL")));
        System.out.println(Arrays.toString(solution(5, "RRRRRDDDDDU")));
        System.out.println(Arrays.toString(solution(6, "RRRRDDDRRDDLLUU")));
    }
}
