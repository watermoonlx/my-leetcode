/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
package 树.N叉树的最大深度_559;

import java.util.LinkedList;
import java.util.List;

public class Solution_559 {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int maxDepthOfChildren = 0;
        for (Node child : root.children) {
            int depth = this.maxDepth(child);
            if (depth > maxDepthOfChildren) {
                maxDepthOfChildren = depth;
            }
        }
        return maxDepthOfChildren + 1;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};