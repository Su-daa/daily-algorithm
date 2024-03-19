package daily0317;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj9466 {
    private static int t,n,cnt;
    private static int[] students;
    private static boolean[] isVisited, done;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            cnt = 0;
            n = Integer.parseInt(br.readLine());

            students = new int[n + 1];
            isVisited = new boolean[n + 1];
            done = new boolean[n + 1];

            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n ; j++) {
                students[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 1; j <=n ; j++) {
                if (!done[j]) {
                    dfs(j);
                }
            }
            System.out.println(n - cnt);
        }
    }

    private static void dfs(int x) {
        if (done[x]) {
            return;
        }
        if (isVisited[x]) {
            done[x] = true;
            cnt++;
        }

        isVisited[x] = true;
        dfs(students[x]);

        done[x] = true;
        isVisited[x] = false;
    }
}
