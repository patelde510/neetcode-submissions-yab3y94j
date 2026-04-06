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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // if (p == null && q == null) return true;

        // if (p != null && q != null && p.val == q.val) {
        //     return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        // }
        
        // return false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            for (int i = 0; i < q1.size(); i++) {
                TreeNode cur1 = q1.poll();
                TreeNode cur2 = q2.poll();

                if (cur1 == null && cur2 == null) continue;

                if (cur1 == null || cur2 == null || cur1.val != cur2.val) {
                    return false;
                }

                q1.add(cur1.left);
                q1.add(cur1.right);
                q2.add(cur2.left);
                q2.add(cur2.right);
            }
        }

        return true;
    }
}
