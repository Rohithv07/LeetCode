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
    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }
    public int findSum(TreeNode node, int sum) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return sum * 10 + node.val;
        return findSum(node.left, sum * 10 + node.val) + findSum(node.right, sum * 10 + node.val);
    }
}
