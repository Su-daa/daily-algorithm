package fc0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class operator {
    public static int MAX=Integer.MIN_VALUE;
    public static int MIN=Integer.MAX_VALUE;
    public static int[] operator=new int[4];
    public static int[] num;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());
        num=new int[n];

        //숫자 배열에 입력
        StringTokenizer st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<n;i++){
            num[i]= Integer.parseInt(st.nextToken());
        }

        //연산자 갯수 배열에 입력
        st=new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            operator[i]= Integer.parseInt(st.nextToken());
        }

        dfs(num[0],1);
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int result,int depth){
        if(depth==n){
            MAX=Math.max(MAX, result);
            MIN=Math.min(MIN,result);
            return;
        }
        for(int i=0;i<4;i++){
            if(operator[i]>0){
                operator[i]--;

                switch (i){
                    case 0:
                        dfs(result+num[depth],depth+1);
                        break;
                    case 1:
                        dfs(result-num[depth],depth+1);
                        break;
                    case 2:
                        dfs(result*num[depth],depth+1);
                        break;
                    case 3:
                        dfs(result/num[depth],depth+1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
