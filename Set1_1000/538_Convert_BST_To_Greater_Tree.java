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
    public TreeNode convertBST(TreeNode root) {
        dfsHelper(root, 0);
        return root;
    }
    
    public int dfsHelper(TreeNode root, int val) {
        if (root == null)
            return val;
        root.val += dfsHelper(root.right, val);
        return dfsHelper(root.left, root.val);
    }
}
