package daily0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1926 {
    private static int n,m,max,area;
    private static int[][] paper;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int num = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j]&&paper[i][j]==1) {
                    num++;
                    dfs(i, j);
                    area = 0;
                }
            }
        }

        System.out.println(num);
        System.out.println(max);
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        area++;
        max = Math.max(area, max);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && !isVisited[nx][ny] && paper[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}
