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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;

        if (iterativeCheck(root, subRoot)) {
            return true;
        }
        
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean iterativeCheck(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) return true;

        if (root != null && subRoot != null && root.val == subRoot.val) {
            return iterativeCheck(root.left, subRoot.left) && iterativeCheck(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
