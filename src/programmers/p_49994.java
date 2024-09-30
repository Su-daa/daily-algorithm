package programmers;

import java.util.HashMap;
import java.util.HashSet;

public class p_49994 {
    // U,D,L,R 적용하는 해시맵 설정
    private static final HashMap<Character, int[]> location = new HashMap<>();

    // 좌표 평면 내에 들어왔는지 여부 확인
    private static boolean isVaild(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < 11 && ny < 11;
    }

    public static void init() {
        location.put('U', new int[]{0, 1});
        location.put('D', new int[]{0, -1});
        location.put('R', new int[]{1, 0});
        location.put('L', new int[]{-1, 0});
    }


    public int solution(String dirs) {
        int x = 5;
        int y = 5;

        // 경로를 스트링으로 저장한다
        HashSet<String> answer = new HashSet<>();
        init();

        for (int i = 0; i < dirs.length(); i++) {
            int[] offset = location.get(dirs.charAt(i));
            int nx = x + offset[0];
            int ny = y + offset[1];

            if (!isVaild(nx, ny)) {
                continue;
            }

            //두개 다 저장해야지 중복 경로를 잡을 수 있다
            answer.add(x + " " + y + " " + nx + " " + ny);
            answer.add(nx + " " + ny + " " + x + " " + y);

            //좌표 업데이트
            x = nx;
            y = ny;
        }
        return answer.size()/2;
    }
}
