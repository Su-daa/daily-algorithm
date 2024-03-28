package daily0328;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1012_2 {
    private static int n,m;

    private static int[][] field;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};

    private static class Cabbage{
        int x;
        int y;

        public Cabbage(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        List<Integer> answer = new ArrayList<>();
        
        while (t > 0) {
            int count =0;
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            isVisited = new boolean[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                field[x][y] = 1;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!isVisited[i][j] && field[i][j] == 1) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            answer.add(count);
            t--;
        }
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }

    private static void bfs(int x, int y) {
        Queue<Cabbage> queue = new LinkedList<>();
        queue.offer(new Cabbage(x, y));
        isVisited[x][y]=true;

        while (!queue.isEmpty()) {
            Cabbage cabbage = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cabbage.x + dx[i];
                int ny = cabbage.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (!isVisited[nx][ny] && field[nx][ny] == 1) {
                        isVisited[nx][ny] = true;
                        queue.offer(new Cabbage(nx, ny));
                    }
                }
            }
        }
    }
}
