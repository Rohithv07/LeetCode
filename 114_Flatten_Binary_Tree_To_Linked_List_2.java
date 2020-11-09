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
    TreeNode previous = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        
        flatten(root.right);
        flatten(root.left); // post order
        root.right = previous;
        root.left = null;
        previous = root;
    }
}
