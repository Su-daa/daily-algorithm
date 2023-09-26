package fc0922;

import java.util.LinkedList;
import java.util.Queue;

public class 미로의최단거리통로 {
    public static int solution(int[][] board){
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        Queue<int[]> Q = new LinkedList<>();
        Q.offer(new int[]{0, 0});
        int L = 0;
        while(!Q.isEmpty()){
            int len = Q.size();
            for(int i = 0; i < len; i++){
                int[] p = Q.poll();
                for(int k = 0; k < 4; k++){
                    int nr = p[0] + dr[k];
                    int nc = p[1] + dc[k];
                    if(nr == 6 && nc == 6) return L+1;
                    if(nr >= 0 && nr < 7 && nc >= 0 && nc < 7 && board[nr][nc] == 0){
                        board[nr][nc] = 1;
                        Q.offer(new int[]{nr, nc});
                    }
                }
            }
            L++;
        }
        return -1;
    }

    public static void main(String[] args){
        int[][] arr={{0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0},
                {1, 1, 0, 1, 0, 1, 1},
                {1, 1, 0, 1, 0, 0, 0},
                {1, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0}};
        System.out.println(solution(arr));
    }
}
