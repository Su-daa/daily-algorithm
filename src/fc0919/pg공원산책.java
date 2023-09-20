package fc0919;

public class pg공원산책 {
    public int[] solution(String[] park, String[] routes) {
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};
        char[] dir = {'N', 'E', 'S', 'W'};
        int n = park.length;
        int m = park[0].length();
        char[][] board = new char[n][];
        int r = 0, c = 0;

        for(int i = 0; i < n; i++){
            board[i] = park[i].toCharArray();
            for(int j = 0; j < m; j++){
                if(board[i][j] == 'S'){
                    r = i;
                    c = j;
                }
            }
        }

        for(String tmp: routes){
            char cmd = tmp.split(" ")[0].charAt(0);
            int dis = Integer.parseInt(tmp.split(" ")[1]);
            boolean flag = true;
            int nr = 0, nc = 0;
            for(int k = 0; k < 4; k++){
                if(cmd == dir[k]){
                    nr = r;
                    nc = c;
                    for(int i = 0; i < dis; i++){
                        nr = nr + dr[k];
                        nc = nc + dc[k];
                        if(nr < 0 || nr >= n || nc < 0 || nc >= m || board[nr][nc] == 'X'){
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag == false) continue;
            r = nr;
            c = nc;
        }
        return new int[]{r, c};
    }
    }

