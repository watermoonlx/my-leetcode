/**
 * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
 */
package 树.二叉搜索树节点最小距离_783;

import java.util.ArrayList;
import java.util.List;

public class Solution_783 {
    // 中序遍历BST，可让节点从小到大依次输出。
    public int minDiffInBST(TreeNode root) {
        List<Integer> midOrder = this.getMidOrder(root);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < midOrder.size() - 1; i++) {
            int curMinDiff = Math.min(
                    midOrder.get(i) - midOrder.get(i - 1),
                    midOrder.get(i + 1) - midOrder.get(i)
            );
            if (curMinDiff < minDiff) {
                minDiff = curMinDiff;
            }
        }
        return minDiff;
    }

    public List<Integer> getMidOrder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(this.getMidOrder(root.left));
        result.add(root.val);
        result.addAll(this.getMidOrder(root.right));
        return result;
    }


//    private int minDiffOfNode(TreeNode node) {
//        if (node.left == null && node.right == null) {
//            return Integer.MAX_VALUE;
//        }
//
//        int leftChildDiff = Integer.MAX_VALUE;
//        if (node.left != null) {
//            TreeNode mostRightOfLeftChild = node.left;
//            while (mostRightOfLeftChild.right != null) {
//                mostRightOfLeftChild = mostRightOfLeftChild.right;
//            }
//            leftChildDiff = node.val - mostRightOfLeftChild.val;
//        }
//
//        int rightChildDiff = Integer.MAX_VALUE;
//        if (node.right != null) {
//            TreeNode mostLeftOfRightChild = node.right;
//            while (mostLeftOfRightChild.left != null) {
//                mostLeftOfRightChild = mostLeftOfRightChild.left;
//            }
//            rightChildDiff = mostLeftOfRightChild.val - node.val;
//        }
//
//        return Math.min(leftChildDiff, rightChildDiff);
//    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
