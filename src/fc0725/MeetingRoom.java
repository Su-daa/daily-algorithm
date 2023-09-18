package fc0725;
import java.util.*;
import java.io.*;
public class MeetingRoom {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N= Integer.parseInt(br.readLine());

        int[][] time = new int[N][2];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            time[i][0]=Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1]=Integer.parseInt(st.nextToken()); // 종료시간
        }

        Arrays.sort(time, (o1, o2) -> {
            if(o1[1] == o2[1]) { //종료시간이 같을 경우 시작 시간이 빠른 순으로 정렬
                return o1[0] - o2[0]; //시작시간 비교하여 오름차순
            }
            return o1[1] - o2[1]; //종료시간 비교하여 오름차순
        });

        int cnt=0;
        int endTime=0;

        for(int i=0;i<N;i++){
            if(endTime<=time[i][0]){
                endTime=time[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
