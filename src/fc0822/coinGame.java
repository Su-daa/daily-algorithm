package fc0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class coinGame {
    public static int[][] coin;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        result=new int[n];

        for(int i=0;i<n;i++){
            //배열 입력받기
            coin=new int[3][3];
            for(int j=0;j<3;j++){
                st=new StringTokenizer(br.readLine());
                String shape = st.nextToken();
                for(int k=0;k<3;k++){
                    //H=0,T=1
                    if(shape.charAt(k)=='H'){
                     coin[j][k]=0;
                    }else {
                        coin[j][k]=1;
                    }
                }
            }
        }

    }

    //뒤집는 경우는 총 6가지 이다
    //1,2,3번째 행 1,2,3번째 열, 오른쪽,왼쪽 대각선
    public static void reverseRow() {

    }

    //다 같은 모양인지 확인
    public static boolean sameCheck(){
        int temp=coin[0][0];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(temp!=coin[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
