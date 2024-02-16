package daily0206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj2606 {
    public static int N,M,ans;
    public static boolean[] isVisited;
    public static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        isVisited = new boolean[N + 1];
        arr = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int start) {
        isVisited[start] = true;
        for (int i = 1; i <= N; i++) {
            if (arr[start][i] == 1 && !isVisited[i]) {
                ans++;
                dfs(i);
            }
        }
    }
}
