package doIt.chap01.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q12 {
    public static void main(String[] args) {
        int n = 9;

        System.out.print("   |");
        for (int i = 1; i <= 9; i++)
            System.out.printf("%3d", i);
        System.out.println("\n---+---------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%3d", i * j);
            System.out.println();
        }

        List<Integer> list = new ArrayList<>();

        /*
        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.printf("%3s|"," ");
            } else {
                System.out.printf("%3d",i);
            }
        }

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                System.out.println();
                for (int j = 0; j < 3; j++) {
                    System.out.print("-");
                }
                System.out.print("+");
                for (int j = 3; j < (n+1)*3; j++) {
                    System.out.print("-");
                }
                System.out.println();
                continue;
            }
            System.out.printf("%3d|",i);
            for (int j = 1; j <= n; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
        */
    }
}
