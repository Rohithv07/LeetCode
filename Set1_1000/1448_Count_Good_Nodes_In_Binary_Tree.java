/*
My thought process
Here the idea is to do the dfs and keep track of the maximum count.
If the current node val >= max, then we can make our result increment by 1 else 0.

And thus we will get the count of all good node.
*/

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
    public int goodNodes(TreeNode root) {
        int max = Integer.MIN_VALUE;
        return dfs(root, max);
    }
    public int dfs(TreeNode node, int max) {
        int result;
        if (node == null)
            return 0;
        if (node.val >= max)
            result = 1;
        else
            result = 0;
        result += dfs(node.left, Math.max(node.val, max));
        result += dfs(node.right, Math.max(node.val, max));
        return result;
        
    }
}
