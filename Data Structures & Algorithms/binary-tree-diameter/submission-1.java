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
    int output = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return output;
    }

    // Calculates the height. Use it to find diameter
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);

        output = Math.max(output, left + right);

        return 1 + Math.max(left, right);
    }
}
