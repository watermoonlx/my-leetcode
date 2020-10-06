/**
 * https://leetcode-cn.com/problems/maximum-product-subarray/
 */
package 动态规划.乘积最大子数组_152;

public class Solution_152 {
    public int maxProduct(int[] nums) {
        int[] maxCache = new int[nums.length];
        int[] minCache = new int[nums.length];
        maxCache[0] = nums[0];
        minCache[0] = nums[0];
        int max = maxCache[0];
        for (int i = 1; i < nums.length; i++) {
            maxCache[i] = Math.max(
                    Math.max(
                            maxCache[i - 1] * nums[i],
                            minCache[i - 1] * nums[i]
                    ),
                    nums[i]
            );
            minCache[i]=Math.min(
                    Math.min(
                            maxCache[i - 1] * nums[i],
                            minCache[i - 1] * nums[i]
                    ),
                    nums[i]
            );
            if (maxCache[i] > max) {
                max = maxCache[i];
            }
        }
        return max;
    }
}
