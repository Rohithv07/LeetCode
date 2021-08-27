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
    private int result;
    public int longestUnivaluePath(TreeNode root) {
        if (root == null)
            return 0;
        result = 0;
        findTheLength(root, root.val);
        return result;
    }
    
    public int findTheLength(TreeNode node, int value) {
        if (node == null)
            return 0;
        int left = findTheLength(node.left, node.val);
        int right = findTheLength(node.right, node.val);
        result = Math.max(result, left + right);
        if (node.val == value) 
            return 1 + Math.max(left, right);
        return 0;
    }
}
