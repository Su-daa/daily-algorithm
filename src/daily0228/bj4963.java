package daily0228;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj4963 {
    private static int N, M;
    private static int[][] land;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) {
                break;
            }
            land = new int[M][N];
            isVisited = new boolean[M][N];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    land[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (land[i][j] == 1 && !isVisited[i][j]) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && land[nx][ny] == 1 && !isVisited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
