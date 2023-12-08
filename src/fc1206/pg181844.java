package fc1206;

import java.util.ArrayList;
import java.util.List;

public class pg181844 {
    public static void main(String[] args) {
        int[] arr = {293,1000,395,678,94};
        int[] deleteList = {94,777,104,1000,1,12};

        List<Integer> answer = new ArrayList<>();
        for (int n : arr){
            boolean delete = false;
            for (int m : deleteList) {
                if(n==m){
                    delete=true;
                }
            }
            if(!delete){
                answer.add(n);
            }
        }

        for (Integer n :
                answer) {
            System.out.println(n);
        }
    }
}
