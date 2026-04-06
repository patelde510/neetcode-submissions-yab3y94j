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
    List<Integer> output = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        bfs(root);
        return output;
    }

    private void bfs(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> q = new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()) {
            output.add(q.getLast().val);
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }

    }
}
