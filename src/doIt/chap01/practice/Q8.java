package doIt.chap01.practice;

public class Q8 {
    public static void main(String[] args) {
        int n = 13;
        if (n % 2 == 0) {
            System.out.println((1 + n) * (n / 2));
        } else {
            System.out.println((1+n)*(n/2)+(1+n)/2);
        }

//        int sum = (n + 1) * (n / 2) + (n % 2 == 1 ? (n + 1) / 2 : 0); // 합

    }
}
