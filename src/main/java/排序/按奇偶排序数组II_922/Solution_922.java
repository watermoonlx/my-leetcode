/**
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii/
 */
package 排序.按奇偶排序数组II_922;

import java.util.LinkedList;

public class Solution_922 {
    public int[] sortArrayByParityII(int[] A) {
//        for (int i = 0; i < A.length; i++) {
//            if (i % 2 == A[i] % 2) {
//                continue;
//            }
//            for (int j = i + 1; j < A.length; j += 2) {
//                if (j % 2 != A[j] % 2) {
//                    int temp = A[i];
//                    A[i] = A[j];
//                    A[j] = temp;
//                    break;
//                }
//            }
//        }
//        return A;

        LinkedList<Integer> wrongOrderedEvenIndex = new LinkedList<>();
        for (int i = 0; i < A.length; i += 2) {
            if (i % 2 != A[i] % 2) {
                wrongOrderedEvenIndex.offer(i);
            }
        }

        for (int i = 1; !wrongOrderedEvenIndex.isEmpty() && i < A.length; i += 2) {
            if (i % 2 != A[i] % 2) {
                Integer evenIndex = wrongOrderedEvenIndex.poll();
                int temp = A[evenIndex];
                A[evenIndex] = A[i];
                A[i] = temp;
            }
        }

        return A;
    }
}
