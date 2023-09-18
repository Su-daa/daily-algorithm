package fc0911;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong((st.nextToken()));
        long b = Long.parseLong((st.nextToken()));
        long c = Long.parseLong((st.nextToken()));
        System.out.println(calculate(a, b, c));
    }

    public static long calculate(long a, long b, long c) {
        if (b == 0) {
            return 1;
        }
        if (b % 2 == 1) {
            return (a * calculate(a, b - 1, c)) % c;
        }
        long k = calculate(a, b / 2, c) % c;
        return (k * k) % c;
    }
}
