package daily0320;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj1260_2 {

    private static int n,m,v;
    private static int[][] graph;
    private static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        graph = new int[n+1][n+1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
        dfs(v);

        System.out.println();

        isVisited = new boolean[n + 1];
        bfs(v);
    }

    private static void dfs(int x) {
        isVisited[x] = true;
        System.out.print(x+" ");

        for (int i = 1; i <= n; i++) {
            if (!isVisited[i] && graph[x][i] == 1) {
                dfs(i);
            }
        }
    }

    private static void bfs(int x) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(x);
        isVisited[x] = true;
        System.out.print(x+" ");

        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 1; i < n+1; i++) {
                if (!isVisited[i] && graph[p][i] == 1) {
                    isVisited[i] = true;
                    queue.offer(i);
                    System.out.print(i+" ");
                }
            }
        }
    }
}
