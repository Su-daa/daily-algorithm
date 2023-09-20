package fc0920;

import java.util.Scanner;

//2*n 타일링
public class bj11726 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%10007; // 마지막에만 나누면 오버플로우 발생
        }
        System.out.println(dp[n]);
    }
}
