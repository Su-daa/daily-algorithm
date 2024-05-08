package doIt.chap01.practice;

public class Q7 {
    public static void main(String[] args) {
        int n = 13;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
            if (i < n) {
                System.out.print(i+"+");
            } else {
                System.out.print(i +"="+ sum);
            }
        }
    }
}
