package daily0223;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2468 {

    private static int N;
    private static int[][] region;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        region = new int[N][N];
        int max = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                region[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, region[i][j]);
            }
        }
        int answer = 0;
        for (int i = 0; i <= max; i++) {
            isVisited = new boolean[N][N];
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (region[j][k] > i && !isVisited[j][k]) {
                        count++;
                        dfs(j, k, i);
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int h) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N && !isVisited[nx][ny] && region[nx][ny] > h){
                dfs(nx, ny, h);
            }
        }
    }
}
