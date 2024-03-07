package daily0307;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2573 {
    /*
    dfs -> 빙산 덩어리 갯수 구하기
    bfs -> 빙산 녹이기
    year++
    => 위의 세 과정 반복
     */
    private static int N, M;
    private static int[][] array;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static class Iceberg{
        int x;
        int y;

        public Iceberg(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        while (true) {
            int island = countIsland();
            if (island >= 2) {
                break;
            } else if (island == 0) {
                year = 0;
                break;
            }
            bfs();
            year++;
        }

        System.out.println(year);
    }

    private static int countIsland() {
        isVisited = new boolean[N][M];

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j] && array[i][j] > 0) {
                    dfs(i, j);
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && !isVisited[nx][ny] && array[nx][ny] > 0) {
                dfs(nx, ny);
            }
        }
    }

    private static void bfs() {
        Queue<Iceberg> q = new LinkedList<>();
        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (array[i][j] > 0) {
                    q.add(new Iceberg(i, j));
                    isVisited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            Iceberg iceberg = q.poll();

            int sea = 0;
            for (int i = 0; i < 4; i++) {
                int nx = iceberg.x + dx[i];
                int ny = iceberg.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (!isVisited[nx][ny] && array[nx][ny] == 0) {
                        sea++;
                    }
                }
            }

            if (array[iceberg.x][iceberg.y] - sea < 0) {
                array[iceberg.x][iceberg.y] = 0;
            } else {
                array[iceberg.x][iceberg.y] -= sea;
            }
        }
    }
}
