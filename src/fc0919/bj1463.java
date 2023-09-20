package fc0919;

import java.util.Scanner;

public class bj1463 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        //각 인덱스 숫자를 1로 만드는데 필요한 최소 연산 횟수 저장
        int[] dp = new int[x + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i <= x; i++) {
            //1을 빼는 경우
            dp[i] = dp[i - 1] + 1;
            //2로 나누어 떨어지는 경우
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
            // 3으로 나누어 떨어지는 경우
            if (i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }
        }

        System.out.println(dp[x]);
    }
}
