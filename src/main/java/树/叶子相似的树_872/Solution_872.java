/**
 * https://leetcode-cn.com/problems/leaf-similar-trees/
 */
package 树.叶子相似的树_872;

import java.util.ArrayList;
import java.util.List;

public class Solution_872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafs1 = new ArrayList<>();
        this.getLeafs(root1, leafs1);
        List<Integer> leafs2 = new ArrayList<>();
        this.getLeafs(root2, leafs2);
        if (leafs1.size() != leafs2.size()) {
            return false;
        }
        for (int i = 0; i < leafs1.size(); i++) {
            if (leafs1.get(i) != leafs2.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void getLeafs(TreeNode root, List<Integer> leafs) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafs.add(root.val);
        } else {
            this.getLeafs(root.left, leafs);
            this.getLeafs(root.right, leafs);
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