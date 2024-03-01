package daily0301;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1987 {
    private static int R, C, max=0;
    private static boolean[] isVisited;
    private static int[][] board;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = str.charAt(j)-'A';
            }
        }

        isVisited = new boolean[26];
        dfs(0, 0, 1);
        System.out.println(max);
    }

    private static void dfs(int x, int y, int len) {
        isVisited[board[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < R && ny >= 0 && ny < C && !isVisited[board[nx][ny]]) {
                dfs(nx,ny,len+1);
                isVisited[board[nx][ny]] = false;
            }
        }
    }
}
