package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class binaryTree {

    private static int[] inorder, postorder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        inorder = new int[n + 1];
        postorder = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n + 1; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        int i = calculateHeight(1, n, 1, n);
        System.out.println(i);
    }

    private static int calculateHeight(int inorderStart, int inorderEnd, int postorderStart, int postorderEnd) {
        if (inorderStart >= inorderEnd || postorderStart >= postorderEnd) {
            return 0;
        }
        // 중위 순회에서 루트 노드 인덱스 찾기 = rootIndex
        int rootValue = postorder[postorderEnd];
        int rootIndex = 0;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }

        int leftSubTreeSize = rootIndex - inorderStart;
        int rightSubTreeSize = inorderEnd - rootIndex;

        if (leftSubTreeSize > rightSubTreeSize) {
            return calculateHeight(inorderStart, rootIndex - 1, postorderStart, postorderStart + leftSubTreeSize - 1) + 1;
        } else {
            return calculateHeight(rootIndex + 1, inorderEnd, postorderEnd - rightSubTreeSize, postorderEnd - 1) + 1;
        }
    }

}
