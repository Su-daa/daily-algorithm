package daily0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10026 {
    static int N;
    static char[][] grid;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N+1][N+1];
        isVisited = new boolean[N+1][N+1];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'G') {
                    grid[i][j] = 'R';
                }
            }
        }

        int nonCnt = 0;
        isVisited = new boolean[N + 1][N + 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j]) {
                    dfs(i, j);
                    nonCnt++;
                }
            }
        }
        System.out.println(cnt+" "+nonCnt);
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx > N || ny < 0 || ny > N) {
                continue;
            }
            if (!isVisited[nx][ny] && grid[nx][ny] == grid[x][y]) {
                dfs(nx, ny);
            }
        }
    }
}
