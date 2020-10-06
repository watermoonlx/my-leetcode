/**
 * https://leetcode-cn.com/problems/sort-integers-by-the-number-of-1-bits/
 */
package 排序.根据数字二进制下1的数目排序_1356;

import java.util.Arrays;
import java.util.HashMap;

public class Solution_1356 {

    public static void main(String[] args) {
        new Solution_1356().sortByBits(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8});
    }

    public int[] sortByBits(int[] arr) {
        HashMap<Integer, Integer> counts = this.get1Counts(arr);
        this.sort(arr, counts);
        return arr;
    }

    private HashMap<Integer, Integer> get1Counts(int[] arr) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int count = 0;
            while (num > 0) {
                count++;
                num &= (num - 1);
            }
            countMap.put(arr[i], count);
        }
        return countMap;
    }

    private void sort(int[] arr, HashMap<Integer, Integer> countMap) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int temp = arr[j];
            for (; j - 1 >= 0 && this.compare(arr[j - 1], temp, countMap) > 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private int compare(int a, int b, HashMap<Integer, Integer> countMap) {
        int countA = countMap.get(a);
        int countB = countMap.get(b);
        if (countA != countB) {
            return countA - countB;
        } else {
            return a - b;
        }
    }

}
