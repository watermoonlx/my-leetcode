/**
 * https://leetcode-cn.com/problems/construct-string-from-binary-tree/
 */
package 树.根据二叉树创建字符串_606;

public class Solution_606 {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }

        String result = String.valueOf(t.val);

        if (t.left != null || t.right != null) {
            if (t.left == null) {
                result += "()";
            } else {
                result += "(" + this.tree2str(t.left) + ")";
            }

            if (t.right != null) {
                result += "(" + this.tree2str(t.right) + ")";
            }
        }
        return result;
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