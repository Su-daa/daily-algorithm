package daily0322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj15486 {
    private static int[] dp;
    private static int[][] counsel;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        dp = new int[n + 2];
        counsel = new int[n + 2][2];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            counsel[i][0] = days;
            counsel[i][1] = money;
        }

        int max = 0;
        for (int i = 1; i < n + 2; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }

            int nextDay = i + counsel[i][0];
            if (nextDay < n + 2) {
                dp[nextDay] = Math.max(dp[nextDay], max + counsel[i][1]);
            }
        }

        System.out.println(max);
    }
}
