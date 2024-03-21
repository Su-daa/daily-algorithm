package daily0321;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj2606_2 {

    private static int n, cnt;
    private static int[][] computers;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        computers = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            computers[x][y] = computers[y][x] = 1;
        }

        cnt = 0;
//        dfs(1);
        bfs(1);
        System.out.println(cnt);
    }

    private static void dfs(int start) {
        isVisited[start] = true;

        for (int i = 1; i < n + 1; i++) {
            if (!isVisited[i] && computers[start][i] == 1) {
                cnt++;
                dfs(i);
            }
        }
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 1; i < n+1; i++) {
                if (!isVisited[i] && computers[p][i] == 1) {
                    isVisited[i] = true;
                    queue.offer(i);
                    cnt++;
                }
            }
        }
    }
}
