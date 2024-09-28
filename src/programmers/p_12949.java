package programmers;

public class p_12949 {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length; //3
        int c1 = arr1[0].length; //2
        int c2 = arr2[0].length; //2

        //결과 행렬의 크기는 r1*c2이다 (c1 == r2)
        int[][] answer = new int[r1][c2];

        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] + arr2[k][j];
                }
            }
        }
        return answer;
    }
}
