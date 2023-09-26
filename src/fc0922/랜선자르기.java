package fc0922;

public class 랜선자르기 {
    public static int solution(int[] nums, int n) {
        int answer = 0, left = 0, right = 0;
        for (int num : nums) {
            right = Math.max(num, right);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            for (int num : nums) {
                cnt += (num / mid);
            }
            if (cnt >= n) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{802, 743, 457, 539}, 11));
        System.out.println(solution(new int[]{8593, 9617, 9313, 4513, 7505, 5457, 8257, 4689, 2657}, 100));
        System.out.println(solution(new int[]{93, 97, 93, 53, 75, 57, 85, 89, 67}, 30));
    }
}
