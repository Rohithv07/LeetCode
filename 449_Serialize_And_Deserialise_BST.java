/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "#";
        String left = serialize(root.left);
        String right = serialize(root.right);
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        sb.append(",");
        sb.append(left);
        sb.append(",");
        sb.append(right);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return helper(queue);
    }
    public TreeNode helper(Queue<String> queue) {
        String s = queue.poll();
        if (s.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = helper(queue);
        node.right = helper(queue);
        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
