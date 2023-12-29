package fc1227;

//연속된 부분 수열의 합
public class pg178870 {
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int left = 0, right = 0, sum = 0;
    	int size = sequence.length;
    	int ans1 = 0 , ans2 =0;

    	for(right=0; right<sequence.length; right++) {
            sum += sequence[right];

    		while(sum > k) {
    			sum -= sequence[left];
    			left++;
    		}

    		if(sum == k) {
    			if(size > right-left) {
    				size = right-left;
    				ans1 = left;
    				ans2 = right;
    			}
    			else if(size == right-left) {
    				ans1 = Math.min(ans1, left);
    				ans2 = Math.min(ans2, right);
    			}
    		}
    	}
    }
}
