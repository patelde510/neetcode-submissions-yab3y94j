/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return count;
    }

    private void dfs(TreeNode node, int curMax) {
        if (node == null) return;

        if (node.val >= curMax) {
            count++;
        }

        if (node.left != null) {
            dfs(node.left, Math.max(curMax, node.left.val));
        }

        if (node.right != null) {
            dfs(node.right, Math.max(curMax, node.right.val));
        }
        
    }
}
