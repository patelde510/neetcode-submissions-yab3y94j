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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        TreeNode search = root;
        while (true) {
            q1.add(search);
            if (p.val > search.val) {
                search = search.right;
            } else if (p.val < search.val) {
                search = search.left;
            } else {
                break;
            }
        }

        search = root;
        while (true) {
            q2.add(search);
            if (q.val > search.val) {
                search = search.right;
            } else if (q.val < search.val) {
                search = search.left;
            } else {
                break;
            }
        }

        TreeNode common = new TreeNode();

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode cur1 = q1.poll();
            TreeNode cur2 = q2.poll();

            if (cur1.val == cur2.val) {
                common = cur1;
            }
        }
        
        return common;
    }
}
