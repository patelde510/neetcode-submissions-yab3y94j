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
    Stack<Integer> stack = new Stack<>();
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return stack.pop();
    }

    private void dfs(TreeNode root, int k) {
        if (root == null) return;

        if (root.left != null) {
            dfs(root.left, k);
        }

        if (stack.size() < k) {
            stack.push(root.val);
        }
        

        if (root.right != null) {
            dfs(root.right, k);
        }
    }
}
