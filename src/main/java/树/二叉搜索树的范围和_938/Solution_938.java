/**
 * https://leetcode-cn.com/problems/range-sum-of-bst/
 */
package 树.二叉搜索树的范围和_938;

public class Solution_938 {
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) {
            return 0;
        }

        if (root.val < L) {
            return this.rangeSumBST(root.right, L, R);
        } else if (root.val > R) {
            return this.rangeSumBST(root.left, L, R);
        } else {
            int leftChildSum = this.rangeSumBST(root.left, L, root.val);
            int rightChildSum = this.rangeSumBST(root.right, root.val, R);
            return root.val + leftChildSum + rightChildSum;
        }
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