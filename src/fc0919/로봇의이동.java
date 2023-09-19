package fc0919;

import java.util.Arrays;

public class 로봇의이동 {
    public static int[] solution(String moves) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int r = 0;
        int c = 0;
        int d = 1;
        for (char command : moves.toCharArray()) {
            if (command == 'G') {
                r = r + dr[d];
                c = c + dc[d];
            } else if (command == 'R') {
                d = (d + 1) % 4;
            } else {
                d = (d + 3) % 4;
            }
        }
        return new int[]{r, c};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("GGGRGGG")));
        System.out.println(Arrays.toString(solution("GGRGGG")));
        System.out.println(Arrays.toString(solution("GGGGGGGRGGGRGGRGGGLGGG")));
        System.out.println(Arrays.toString(solution("GGLLLGLGGG")));
    }
}
