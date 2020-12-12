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
    private Map<TreeNode, Integer> map = new HashMap<>();
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null)
            return null;
        int left = dfs(root.left);
        int right = dfs(root.right);
        if (left == right)
            return root;
        if (left > right)
            return subtreeWithAllDeepest(root.left);
        return subtreeWithAllDeepest(root.right);
    }
    public int dfs(TreeNode node) {
        if (node == null)
            return 0;
        if (map.containsKey(node))
            return map.get(node);
        int max = Math.max(dfs(node.left), dfs(node.right)) + 1;
        map.put(node, max);
        return max;
    }
}
