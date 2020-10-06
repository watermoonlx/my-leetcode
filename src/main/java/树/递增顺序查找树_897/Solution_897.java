/**
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 */
package 树.递增顺序查找树_897;

import java.util.ArrayList;
import java.util.List;

public class Solution_897 {
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> midOrderList = this.getMidOrderList(root);
        int size = midOrderList.size();
        if (size == 0) {
            return null;
        }
        for (int i = 0; i < size; i++) {
            TreeNode node = midOrderList.get(i);
            node.left = null;
            if (i + 1 < size) {
                node.right = midOrderList.get(i + 1);
            }else {
                node.right = null;
            }
        }
        return midOrderList.get(0);
    }

    private List<TreeNode> getMidOrderList(TreeNode root) {
        ArrayList<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(this.getMidOrderList(root.left));
        result.add(root);
        result.addAll(this.getMidOrderList(root.right));
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
