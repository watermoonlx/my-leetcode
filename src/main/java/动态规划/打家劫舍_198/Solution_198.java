/**
 * https://leetcode-cn.com/problems/house-robber/
 */
package 动态规划.打家劫舍_198;

public class Solution_198 {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int prev2Max = nums[0];
        int prev1Max = Math.max(nums[0], nums[1]);
        int max = Math.max(
                prev1Max,
                prev2Max
        );
        for (int i = 2; i < nums.length; i++) {
            int curMax = Math.max(
                    prev2Max + nums[i],
                    prev1Max
            );
            if (curMax > max) {
                max = curMax;
            }
            prev2Max = prev1Max;
            prev1Max = curMax;
        }

        return max;
    }
}
