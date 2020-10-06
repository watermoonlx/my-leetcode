/**
 * https://leetcode-cn.com/problems/the-masseuse-lcci/
 */
package 动态规划.按摩师_面试题_17_16;

public class Solution_面试题_17_16 {
    public int massage(int[] nums) {
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int[] cache = new int[nums.length];
        cache[0] = nums[0];
        cache[1] = Math.max(
                cache[0],
                nums[1]
        );
        for (int i = 2; i < nums.length; i++) {
            cache[i] = Math.max(
                    cache[i - 2] + nums[i],
                    cache[i - 1]
            );
        }

        return cache[nums.length - 1];
    }
}
