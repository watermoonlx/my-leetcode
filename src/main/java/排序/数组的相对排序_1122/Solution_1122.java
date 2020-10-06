/**
 * https://leetcode-cn.com/problems/relative-sort-array/
 */
package 排序.数组的相对排序_1122;

import java.util.*;

public class Solution_1122 {

    public static void main(String[] args) {
        new Solution_1122().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6});
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] counts = new int[1001];
        for (int num : arr1) {
            counts[num]++;
        }
        int index = 0;
        for (int num : arr2) {
            while (counts[num] > 0) {
                arr1[index++] = num;
                counts[num]--;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            while (counts[i] > 0) {
                arr1[index++] = i;
                counts[i]--;
            }
        }
        return arr1;
    }
}
