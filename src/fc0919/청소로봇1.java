package fc0919;

import java.util.Arrays;

public class 청소로봇1 {
    public static void main(String[] args){
        System.out.println(Arrays.toString(solution("RRRDDDLU")));
        System.out.println(Arrays.toString(solution("DDDRRRDDLL")));
        System.out.println(Arrays.toString(solution("RRRRRRDDDDDDUULLL")));
        System.out.println(Arrays.toString(solution("RRRRDDDRRDDLLUU")));
    }
    public static int[] solution(String moves){
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        int[] dir = {'U', 'R', 'D', 'L'};
        int r = 0;
        int c = 0;
        for(char command : moves.toCharArray()){
            for(int k = 0; k < 4; k++){
                if(command == dir[k]){
                    r = r + dr[k];
                    c = c + dc[k];
                }
            }
        }
        return new int[]{r, c};
    }
}
