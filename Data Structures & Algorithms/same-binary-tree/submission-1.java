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
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        if (p != null && q != null) {
            q1.add(p);
            q2.add(q);
        } else if (p == null ^ q == null) {
            return false;
        } 

        while (!q1.isEmpty() && !q2.isEmpty()) {
            int size1 = q1.size();
            int size2 = q2.size();
            if (size1 != size2) return false;

            for (int i = 0; i < size1; i++) {
                TreeNode cur1 = q1.poll();
                TreeNode cur2 = q2.poll();

                if (cur1.val != cur2.val) return false;

                if (cur1.left != null && cur2.left != null) {
                    if (cur1.left.val == cur2.left.val) {
                        q1.add(cur1.left);
                        q2.add(cur2.left);
                    } else {
                        return false;
                    }
                } else if (cur1.left == null ^ cur2.left == null) {
                    return false;
                } 

                if (cur1.right != null && cur2.right != null) {
                    if (cur1.right.val == cur2.right.val) {
                        q1.add(cur1.right);
                        q2.add(cur2.right);
                    } else {
                        return false;
                    }
                } else if (cur1.right == null ^ cur2.right == null) {
                    return false;
                }
            }
        }

        return true;
    }
}
