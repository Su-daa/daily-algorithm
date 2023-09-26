package fc0922;

import java.util.LinkedList;
import java.util.Queue;

public class 최소점프 {
    public static int solution(int home) {
        Queue<Integer> Q = new LinkedList<>();
        int[] ch = new int[10001];
        Q.offer(0);
        ch[0] = 1;
        int L = 0;
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int i = 0; i < n; i++) {
                int x = Q.poll();
                for (int nx : new int[]{x - 1, x + 1, x + 5}) {
                    if (nx == home) return L + 1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(solution(10));
        System.out.println(solution(14));
        System.out.println(solution(25));
        System.out.println(solution(24));
        System.out.println(solution(345));
    }
}
