package 树.把二叉搜索树转换为累加树_538;

public class Solution_538 {

    private int biggerSum = 0;

    public TreeNode convertBST(TreeNode root) {
        this.traverse(root);
        return root;
    }

    public void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        this.traverse(root.right);
        root.val += this.biggerSum;
        this.biggerSum = root.val;
        this.traverse(root.left);
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