package daily0229;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj11725 {

    private static int N;
    private static boolean[] isVisited;
    private static List<List<Integer>> adjList;
    private static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        isVisited = new boolean[N + 1];
        answer = new int[N + 1];

        adjList = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList.get(x).add(y);
            adjList.get(y).add(x);
        }

        dfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    static void dfs(int current) {
        isVisited[current] = true;

        for (int node : adjList.get(current)) {
            if (!isVisited[node]) {
                answer[node] = current;
                dfs(node);
            }
        }
    }
}
