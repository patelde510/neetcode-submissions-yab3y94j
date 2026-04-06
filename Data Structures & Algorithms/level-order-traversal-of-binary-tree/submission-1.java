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
    List<List<Integer>> output = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        // List<List<Integer>> output = new ArrayList<>();

        // if (root == null) return output;

        // Queue<TreeNode> curLevelNodes = new LinkedList<>();
        // curLevelNodes.add(root);

        // while (!curLevelNodes.isEmpty()) {
        //     List<Integer> curLevel = new ArrayList<>();

        //     int levelSize = curLevelNodes.size();
        //     for (int i = 0; i < levelSize; i++) {
        //         TreeNode cur = curLevelNodes.poll();

        //         curLevel.add(cur.val);

        //         if (cur.left != null) {
        //             curLevelNodes.add(cur.left);
        //         }
        //         if (cur.right != null) {
        //             curLevelNodes.add(cur.right);
        //         }
        //     }
        //     output.add(curLevel);
        // }

        // return output;

        dfs(root, 0);
        return output;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) return;

        if (output.size() == depth) {
            output.add(new ArrayList<>());
        }

        output.get(depth).add(root.val);

        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
