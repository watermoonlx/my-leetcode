/**
 * https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 */
package 动态规划.连续子数组的最大和_剑指Offer_42;

public class Solution_剑指Offer_42 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int curMax = nums[0];
        int max = curMax;
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(
                    curMax + nums[i],
                    nums[i]
            );
            if (curMax > max) {
                max = curMax;
            }
        }

        return max;
    }
}
