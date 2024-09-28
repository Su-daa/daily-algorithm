package programmers;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class p_42889 {
    public static void main(String[] args) {
        solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
    }
    public static int[] solution(int N, int[] stages) {
        // 스테이지 배열 놔둔다면? 스테이지 별로 현재 도전자 수를 따로 저장
        // i번쩨 저장된 사람~ N번째 저장된 사람 : 스테이지에 도달한 사람
        // 도달햇으나 아직 클리어 하지 못한 플레이어 수 : i번째 저장된 수
        int[] stage = new int[N + 2];
        for (int j : stages) {
            stage[j]++;
        }

        double totalUsers = stages.length;
        // hashmap 으로 스테이지:실패율 저장
        HashMap<Integer, Double> failureRate = new HashMap<>();
        for (int i = 1; i < stage.length-1; i++) {
            if (stage[i] == 0) {
                failureRate.put(i, 0.);
            }
            else {
                failureRate.put(i, stage[i] / totalUsers);
                totalUsers = totalUsers - stage[i];
            }
        }
        System.out.println("failureRate = " + failureRate);

        return failureRate.entrySet().stream().sorted(((o1, o2) -> Double.compare(o2.getValue(), o1.getValue())))
                .mapToInt(Map.Entry::getKey).toArray();
    }
}
