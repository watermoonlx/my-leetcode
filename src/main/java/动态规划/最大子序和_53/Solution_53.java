/**
 * https://leetcode-cn.com/problems/maximum-subarray/
 */
package 动态规划.最大子序和_53;

public class Solution_53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int curMax = nums[0];
        int max = curMax;
        for (int i = 1; i < nums.length; i++) {
            curMax=Math.max(
                    curMax+nums[i],
                    nums[i]
            );
            if (curMax > max) {
                max = curMax;
            }
        }

        return max;
    }
}
