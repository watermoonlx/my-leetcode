/**
 *
 */
package 树.二叉树的所有路径_257;

import java.util.ArrayList;
import java.util.List;

public class Solution_257 {

    private List<String> paths = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode root) {
        this.traverse(root, "");
        return this.paths;
    }

    private void traverse(TreeNode root, String curPath) {
        if (root == null) {
            return;
        }

        if (curPath.equals("")) {
            curPath += root.val;
        } else {
            curPath += "->" + root.val;
        }
        if (root.left == null && root.right == null) {
            this.paths.add(curPath);
        } else {
            this.traverse(root.left, curPath);
            this.traverse(root.right, curPath);
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




