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
// post order
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode left = pruneTree(root.left);
        root.left = left;
        TreeNode right = pruneTree(root.right);
        root.right = right;
        if (root.val == 0 && root.left == null && root.right == null)
            return null;
        return root;
    }
}