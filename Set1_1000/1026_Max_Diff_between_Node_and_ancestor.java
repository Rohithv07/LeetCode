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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        return dfsHelper(root, root.val, root.val);
    }
    public int dfsHelper(TreeNode node, int currentMax, int currentMin) {
        if (node == null)
            return currentMax - currentMin;
        // update max and min
        currentMax = Math.max(currentMax, node.val);
        currentMin = Math.min(currentMin, node.val);
        return Math.max(dfsHelper(node.left, currentMax, currentMin), dfsHelper(node.right, currentMax, currentMin));
    }
}
