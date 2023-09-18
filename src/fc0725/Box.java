package fc0725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Box {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        int[] centerX=new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            centerX[i]=Integer.parseInt(st.nextToken());
        }

        long[] calCenter= new long[n];
        calCenter[0]=centerX[0];
        for(int i=1; i<n;i++){
            calCenter[i]=calCenter[i-1]+centerX[i];
        }

        for(int i=0;i<n-1;i++){
            double x = (double) (calCenter[n - 1] - calCenter[i]) / (n - i - 1);
            if(x <=centerX[i]-L|| x >=centerX[i]+L){
                System.out.println("unstable");
                return;
            }
        }
        System.out.println("stable");
    }
}

