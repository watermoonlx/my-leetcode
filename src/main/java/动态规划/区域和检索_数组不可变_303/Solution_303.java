package 动态规划.区域和检索_数组不可变_303;

public class Solution_303 {

}

class NumArray {

    private final int[] nums;
    private final int[] cache;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            this.nums = null;
            this.cache = null;
            return;
        }
        this.nums = nums;
        this.cache = new int[nums.length];
        this.cache[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            this.cache[i] = this.cache[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return this.cache[j] - this.cache[i] + this.nums[i];
    }
}
