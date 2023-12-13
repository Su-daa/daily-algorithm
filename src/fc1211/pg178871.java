package fc1211;

import java.util.HashMap;
import java.util.Map;

//달리기 경주
public class pg178871 {
    public static void main(String[] args) {
        String[] player = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};

        Map<String, Integer> map = new HashMap<>();

        //<선수, 랭크> 저장
        for (int i = 0; i < player.length; i++) {
            map.put(player[i], i);
        }

        for (String calling : callings) {
            int rank = map.get(calling);

            String prePlayer = player[rank - 1];
            player[rank-1] = calling;
            player[rank] = prePlayer;
            map.replace(calling,rank-1);
            map.replace(prePlayer, rank);
        }

        for (String s : player) {
            System.out.println(s);
        }
    }
}
