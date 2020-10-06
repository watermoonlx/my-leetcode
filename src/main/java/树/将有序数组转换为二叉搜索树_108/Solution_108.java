/**
 * https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree/
 */
package 树.将有序数组转换为二叉搜索树_108;

public class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return this.sortedArrayToBSTRec(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBSTRec(int[] nums, int left, int right) {
        if (left == right) {
            return new TreeNode(nums[left]);
        }

        int midIndex = (left + right) / 2;
        TreeNode root = new TreeNode(nums[midIndex]);
        if (left < midIndex) {
            root.left = this.sortedArrayToBSTRec(nums, left, midIndex-1);
        }
        if (right > midIndex) {
            root.right = this.sortedArrayToBSTRec(nums, midIndex + 1, right);
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}