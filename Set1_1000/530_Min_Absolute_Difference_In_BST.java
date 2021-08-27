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
    int min = Integer.MAX_VALUE;
    int prev;
    public int getMinimumDifference(TreeNode root) {
		prev= -1;
		dfs(root);
		return min;
	}
	public void dfs(TreeNode node) {
		if (node == null)
			return;
		dfs(node.left);
		if (prev != -1)
			min = Math.min(min, Math.abs(prev - node.val));
		prev = node.val;
		dfs(node.right);
	}
}

