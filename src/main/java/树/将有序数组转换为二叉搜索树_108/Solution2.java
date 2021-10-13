package 树.将有序数组转换为二叉搜索树_108;

import 树.TreeNode;

public class Solution2 {
    public TreeNode sortedArrayToBST(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        return sortedArrayToBST(nums, start, end);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        int middle = (start + end) / 2;
        int count = end - start + 1;
        if (count == 1) {
            return new TreeNode(nums[middle]);
        } else if (count == 2) {
            TreeNode root = new TreeNode(nums[start]);
            root.right = new TreeNode(nums[end]);
            return root;
        } else {
            TreeNode root = new TreeNode(nums[middle]);
            root.left = sortedArrayToBST(nums, start, middle - 1);
            root.right = sortedArrayToBST(nums, middle + 1, end);
            return root;
        }
    }
}
