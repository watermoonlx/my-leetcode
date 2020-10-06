package 树.二叉搜索树中的搜索_700;

public class Solution_700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        } else {
            if (root.val == val) {
                return root;
            } else if (val < root.val) {
                return this.searchBST(root.left, val);
            } else {
                return this.searchBST(root.right, val);
            }
        }
    }

    public TreeNode searchBSTLoop(TreeNode root, int val) {
        while (root != null && root.val != val) {
            root = val < root.val ? root.left : root.right;
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