package doIt.chap01;

public class Median {
    static int med3(int a, int b, int c) {
        if (a >= b) {
            if (b >= c) {
                return b;
            } else if (a <= c) {
                return a;
            } else {
                return c;
            }
        } else if (a > c) {
            return a;
        }else {
            if (c >= b) {
                return b;
            } else {
                return c;
            }
        }
    }

    public static void main(String[] args) {
        int i = med3(1, 3, 2);
        System.out.println(i);
    }
}
