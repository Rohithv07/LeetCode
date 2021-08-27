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
    public int findTilt(TreeNode root) {
        int [] tilt = new int [1];
        dfsHelper(root, tilt);
        return tilt[0];
    }
    public int dfsHelper(TreeNode node, int [] tilt) {
        if (node == null)
            return 0;
        int left = dfsHelper(node.left, tilt);
        int right = dfsHelper(node.right, tilt);
        tilt[0] += Math.abs(left - right);
        return left + right + node.val;
    }
}
