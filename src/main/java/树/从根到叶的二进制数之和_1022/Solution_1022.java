/**
 * https://leetcode-cn.com/problems/sum-of-root-to-leaf-binary-numbers/
 */
package 树.从根到叶的二进制数之和_1022;

import java.util.ArrayList;

public class Solution_1022 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int result = new Solution_1022().sumRootToLeaf(root);
    }

    private int sum = 0;

    public int sumRootToLeaf(TreeNode root) {
        this.sumRootToLeafRec(root, 0);
        return this.sum;
    }

    private void sumRootToLeafRec(TreeNode root, int tempSum) {
        tempSum = tempSum * 2 + root.val;

        if (root.left == null && root.right == null) {
            this.sum += tempSum;
        } else {
            if (root.left != null) {
                this.sumRootToLeafRec(root.left, tempSum);
            }
            if (root.right != null) {
                this.sumRootToLeafRec(root.right, tempSum);
            }
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