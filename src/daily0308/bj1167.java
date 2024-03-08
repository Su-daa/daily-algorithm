package daily0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj1167 {
    private static List<Node>[] tree;
    private static boolean[] isVisited;
    private static int V,max,maxNode;

    private static class Node{
        int x;
        int dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            while (true) {
                int v = Integer.parseInt(st.nextToken());
                if (v == -1) {
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                tree[u].add(new Node(v, dist));
            }
        }

        isVisited = new boolean[V + 1];
        dfs(1, 0);

        isVisited = new boolean[V + 1];
        dfs(maxNode, 0);

        System.out.println(max);
    }

    private static void dfs(int x, int len) {
        isVisited[x] = true;

        if (len > max) {
            max = len;
            maxNode = x;
        }

        for (Node node : tree[x]) {
            if (!isVisited[node.x]) {
                dfs(node.x, len + node.dist);
            }
        }
    }
}
