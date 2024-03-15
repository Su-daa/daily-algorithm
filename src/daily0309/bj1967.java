package daily0309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1967 {
    private static int N, maxNode, diameter;
    private static List<Node>[] tree;
    private static boolean[] isVisited;
    private static class Node{
        int x;
        int weight;

        public Node(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[x].add(new Node(y, weight));
        }

        isVisited = new boolean[N + 1];
        dfs(1, 0);

        isVisited = new boolean[N + 1];
        dfs(maxNode, 0);
        System.out.println(diameter);
    }

    private static void dfs(int x, int len) {
        isVisited[x] = true;

        if (diameter < len) {
            diameter = len;
            maxNode = x;
        }

        for (Node node : tree[x]) {
            if (!isVisited[node.x]) {
                dfs(node.x, len + node.weight);
            }
        }
    }
}
