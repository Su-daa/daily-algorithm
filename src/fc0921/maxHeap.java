package fc0921;

public class maxHeap {
    public int[] heap;
    public int size;

    public maxHeap(int length) {
        this.heap = new int[length];
        heap[0]=Integer.MAX_VALUE;
        size=0;
    }

    private void upHeap(int pos) {
        int tmp = heap[pos];
        while (heap[pos / 2] < tmp) { //부모가 자기보다 작은수일 경우
            heap[pos] = heap[pos / 2];
            pos=pos/2; //pos를 부모인덱스로 변경
        }
        heap[pos]=tmp; //미리 저장해놓은 값을 그 올라간 인덱스의 자리로 넣어준다
    }

    public void insert(int num) {
        heap[++size]=num;
        upHeap(size);
    }
}
