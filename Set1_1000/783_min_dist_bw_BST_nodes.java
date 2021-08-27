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
    int minimumValue = Integer.MAX_VALUE;
    int prev;
    public int minDiffInBST(TreeNode root) {
        prev = -1;
        dfs(root);
        return minimumValue;
    }
    public void dfs(TreeNode node) {
        if (node == null)
            return;
        dfs(node.left);
        if (prev != -1)
            minimumValue = Math.min(minimumValue, Math.abs(prev-node.val));
        prev = node.val;
        dfs(node.right);
    }
}
