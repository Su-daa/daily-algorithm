package daily0325;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class bj2667_2 {
    private static int n;
    private static int[][] array;
    private static boolean[][] isVisited;
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
    private static ArrayList<Integer> answer;

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        array = new int[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                array[i][j] = s.charAt(j) - '0';
            }
        }

        int count = 0;
        answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && array[i][j] == 1) {
                    count++;
                    bfs(i, j);
                }
            }
        }

        Collections.sort(answer);
        System.out.println(count);
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }

    private static void bfs(int x, int y) {
        int num = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        isVisited[x][y] = true;

        while (!queue.isEmpty()) {
            Point p = queue.poll();
            num++;
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(nx<n&&ny<n&&nx>=0&&ny>=0){
                    if (!isVisited[nx][ny] && array[nx][ny] == 1) {
                        queue.offer(new Point(nx, ny));
                        isVisited[nx][ny] = true;
                    }
                }
            }
        }
        answer.add(num);
    }
}
