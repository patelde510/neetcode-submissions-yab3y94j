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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE});
    }

    public boolean isValid(TreeNode root, int[] range) {
        if (root == null) return true;
        if (root.val > range[0] && root.val < range[1]) {
            return isValid(root.left, new int[]{range[0], root.val}) &&
                    isValid(root.right, new int[]{root.val, range[1]});
        } else {
            return false;
        }
    }
}
