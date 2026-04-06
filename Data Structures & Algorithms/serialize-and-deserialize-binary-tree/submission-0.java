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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";
        StringBuilder output = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();

            if (cur == null) {
                output.append("N,");
            } else {
                output.append(cur.val).append(",");
                q.add(cur.left);
                q.add(cur.right);
            }
        }
        System.out.println(output.toString());
        return output.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        if (split[0].equals("N")) return null;

        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int i = 1;

        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            int dataLen = split.length;

            if (i < dataLen) {
                if (!split[i].equals("N")) {
                    TreeNode tempL = new TreeNode(Integer.parseInt(split[i]));
                    cur.left = tempL;
                    q.add(cur.left); 
                }
                i++;
            }

            if (i < dataLen) {
                if (!split[i].equals("N")) {
                    TreeNode tempR = new TreeNode(Integer.parseInt(split[i]));
                    cur.right = tempR;
                    q.add(cur.right);
                }
                i++;
            }
            
        }
       
        return root;
    }
}
