package fc1229;

import java.util.Comparator;

//광물 캐기
public class pg172927 {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};


    }
    class Mineral {
        String name;
        int score;

        public Mineral(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    class MineralComparator implements Comparator<Mineral> {

        @Override
        public int compare(Mineral o1, Mineral o2) {
            
            return 0;
        }
    }
}
