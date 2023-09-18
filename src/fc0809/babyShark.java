package fc0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class babyShark {
    public static int[][] board;
    public static int n,time,size;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        size=2;
        n= Integer.parseInt(br.readLine());
        board=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                board[i][j]= Integer.parseInt(st.nextToken());
            }
        }


    }
}
