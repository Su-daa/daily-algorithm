package daliy0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1260 {
    public static int N,M,V;
    public static boolean[] isVisited;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        V= Integer.parseInt(st.nextToken());

        isVisited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[x][y] = arr[y][x] = 1;
        }
        dfs(V);
        System.out.println();

        Arrays.fill(isVisited,false);
        bfs(V);
    }

    public static void dfs(int start) {
        isVisited[start] = true;
        System.out.print(start+" ");

        for (int i = 0; i <= N; i++) {
            if (arr[start][i] == 1 && !isVisited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisited[start] = true;

        System.out.print(start + " ");

        while (!queue.isEmpty()) {
            int n = queue.poll();
            // 노드 하나로 연결된 노드 먼저 다 체크
            for(int i = 1; i < arr.length; i++) {
                // 연결된 노드인데 방문하지 않은 경우
                if(arr[n][i] == 1 && !isVisited[i]) {
                    isVisited[i] = true;
                    System.out.print(i + " ");
                    queue.offer(i);
                }
            }
        }
    }
}
