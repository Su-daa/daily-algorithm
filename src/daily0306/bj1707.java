package daily0306;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj1707 {
    private static int T,V,E;
    private static Node[] nodes;
    private static boolean[] isVisited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- != 0) {
            st = new StringTokenizer(br.readLine());

            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            nodes = new Node[V + 1];
            isVisited = new boolean[V + 1];

            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node(i);
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                nodes[u].child.add(nodes[v]);
                nodes[v].child.add(nodes[u]);
            }
            boolean answer = true;
            for (int i = 1; i <= V ; i++) {
                if (!isVisited[i]) {
                    isVisited[i] = true;
                    nodes[i].setColor(1);
                    if (!bfs(i)) {
                        answer = false;
                        break;
                    }
                }
            }
            System.out.println(answer ? "YES" : "NO");
        }
    }

    private static boolean bfs(int idx) {
        Queue<Node> q = new LinkedList<>();
        q.add(nodes[idx]);

        while (!q.isEmpty()) {
            Node node = q.poll();

            if (check(node)) {
                return false;
            } else {
                for (Node child : node.child) {
                    if (!isVisited[child.idx]) {
                        isVisited[child.idx] = true;
                        child.setColor(1 - node.color);
                        q.add(child);
                    }
                }
            }
        }
        return true;
    }

    private static boolean check(Node node) {
        for (Node child : node.child) {
            if (isVisited[child.idx] && child.color == node.color) {
                return true;
            }
        }
        return false;
    }

    private static class Node{
        int idx;
        int color;

        List<Node> child = new ArrayList<>();

        public Node(int idx) {
            this.idx = idx;
        }

        public void setColor(int color) {
            this.color = color;
        }
    }
}
