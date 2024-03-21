package daily0319;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj13023 {
    private static int n, m, answer;
    private static boolean[] isVisited;
    private static Map<Integer, List<Integer>> friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        friends = new HashMap<>();
        isVisited = new boolean[n];

        for (int i = 0; i < n; i++) {
            friends.put(i, new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int friend = Integer.parseInt(st.nextToken());
            friends.get(idx).add(friend);
            friends.get(friend).add(idx);
        }

        answer = 0;
        for (int i = 0; i < n; i++) {
            if (answer != 1) {
                dfs(i,1);
            }
        }
        System.out.println(answer);
    }

    private static void dfs(int x, int depth) {
        if (depth == 5) {
            answer = 1;
            return;
        }

        isVisited[x] = true;
        for (int i : friends.get(x)) {
            if (!isVisited[i]) {
                dfs(i, depth + 1);
            }
        }
        isVisited[x] = false;
    }
}
