/**
 * https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 */
package 树.二叉树中第二小的节点_671;

public class Solution_671 {

    public int findSecondMinimumValue(TreeNode root) {
        return this.findSecondMinimumValueRec(root, root.val);
    }

    private int findSecondMinimumValueRec(TreeNode root, int min) {
        if (root.val == min) {
            if (root.left == null) {
                return -1;
            } else {
                int leftMin = this.findSecondMinimumValueRec(root.left, min);
                int rightMin = this.findSecondMinimumValueRec(root.right, min);
                return this.minOfTwo(leftMin, rightMin);
            }
        } else {
            return root.val;
        }
    }

    private int minOfTwo(int leftMin, int rightMin) {
        if (leftMin == -1 && rightMin == -1) {
            return -1;
        } else if (leftMin != -1 && rightMin != -1) {
            return leftMin < rightMin ? leftMin : rightMin;
        } else if (leftMin != -1) {
            return leftMin;
        } else {
            return rightMin;
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