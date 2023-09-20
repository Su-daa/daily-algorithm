package fc0920;

public class pg키패드누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        int left = 10;
        int right = 11;

        //거리를 이차원 배열로 초기화
        // 0 1 2 3 4 5 6 7 8 9 각각 이차원 배열 인덱스=키패드 숫자
        int[][] dist = {{0, 0, 3, 0, 0, 2, 0, 0, 1, 0},
                {4, 0, 1, 0, 0, 2, 0, 0, 3, 0},
                {3, 0, 0, 0, 0, 1, 0, 0, 2, 0},
                {4, 0, 1, 0, 0, 2, 0, 0, 3, 0},
                {3, 0, 2, 0, 0, 1, 0, 0, 2, 0},
                {2, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {3, 0, 2, 0, 0, 1, 0, 0, 2, 0},
                {2, 0, 3, 0, 0, 2, 0, 0, 1, 0},
                {1, 0, 2, 0, 0, 1, 0, 0, 0, 0},
                {2, 0, 3, 0, 0, 2, 0, 0, 1, 0},
                {1, 0, 4, 0, 0, 3, 0, 0, 2, 0},
                {1, 0, 4, 0, 0, 3, 0, 0, 2, 0}};
        for (int i = 0; i < numbers.length; i++) {
            int n = numbers[i];
            if (n == 1 || n == 4 || n == 7) {
                left = n;
                sb.append("L");
            }
            else if (n == 3 || n == 6 || n == 9) {
                right = n;
                sb.append("R");
            }
            else{
                if(dist[left][n] < dist[right][n]){
                    left = n;
                    sb.append('L');
                }
                else if(dist[left][n] > dist[right][n]){
                    right = n;
                    sb.append('R');
                }
                else if(hand.equals("left")){
                    left = n;
                    sb.append('L');
                }
                else{
                    right = n;
                    sb.append('R');
                }
            }
        }
        return sb.toString();
    }
}
