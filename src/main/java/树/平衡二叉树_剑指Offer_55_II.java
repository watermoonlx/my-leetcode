package 树;

import javafx.util.Pair;
import sun.nio.cs.ext.MacHebrew;

public class 平衡二叉树_剑指Offer_55_II {
    public boolean isBalanced(TreeNode root) {
        return this.checkIsBalanced(root).getKey();
    }

    private Pair<Boolean, Integer> checkIsBalanced(TreeNode root) {
        if (root == null) {
            return new Pair<>(true, 0);
        }

        Pair<Boolean, Integer> leftResult = this.checkIsBalanced(root.left);
        if (!leftResult.getKey()) {
            return new Pair<>(false, leftResult.getValue() + 1);
        }
        Pair<Boolean, Integer> rightResult = this.checkIsBalanced(root.right);
        if (!rightResult.getKey()) {
            return new Pair<>(false, rightResult.getValue() + 1);
        }

        return new Pair<>(
                Math.abs(leftResult.getValue() - rightResult.getValue()) <= 1,
                Math.max(leftResult.getValue(), rightResult.getValue()) + 1
        );
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
