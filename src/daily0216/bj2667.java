package daily0216;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2667 {
    public static int N, cnt;
    public static int[][] arrays;
    public static boolean[][] isVisited;
    public static int[] dx = {0,0,-1,1};
    public static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arrays = new int[N][N];
        isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arrays[i][j] = str.charAt(j)-'0';
            }
        }

        List<Integer> answer = new ArrayList<>();
        cnt = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (arrays[i][j] == 1 && !isVisited[i][j]) {
                    dfs(i,j);
                    answer.add(cnt);
                    cnt = 1;
                }
            }
        }

        Collections.sort(answer);
        for (Integer i : answer) {
            System.out.println(i);
        }
    }

    public static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nx = dx[i]+x;
            int ny = dy[i]+y;

            if(nx>=0 && ny>=0 && nx<N && ny<N && !isVisited[nx][ny] && arrays[nx][ny]==1) {
                cnt++;
                dfs(nx,ny);
            }
        }
    }
}
