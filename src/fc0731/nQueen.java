package fc0731;

import java.util.Scanner;

public class nQueen {
    public static int[] arr;
    public static int N,cnt;

    //퀸은 상하좌우 대각선으로 한방향 이동 가능
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N=sc.nextInt();
        arr=new int[N];

        dfs(0);
        System.out.println(cnt);

    }
    public static void dfs(int col){
        if(col==N){
            cnt++;
            return;
        }
        for(int i=0;i<N;i++){
            arr[col]=i;
            if(check(col)){
                dfs(col+1);
            }
        }
    }
    public static boolean check(int col){
        for(int i=0;i<col;i++){
            if(arr[col]==arr[i]){
                return false;
            }
            //열의 차==행의 차 일 경우 대각선에 위치한다.
            else if (col-i==Math.abs(arr[col]-arr[i])) {
                return false;
            }
        }
        return true;
    }
}
