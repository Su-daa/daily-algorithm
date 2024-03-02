package daily0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class bj2583 {

    private static int M,N,count;
    private static int[][] board;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[M][N];
        isVisited = new boolean[M][N];

        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for (int j = x1; j < x2; j++) {
                for (int l = y1; l < y2; l++) {
                    board[l][j] = 1;
                }
            }
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && board[i][j] == 0) {
                    count = 0;
                    dfs(i, j);
                    answer.add(count);
                }
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        for (Integer i : answer) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < M && ny >= 0 && ny < N && board[nx][ny] == 0 && !isVisited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
