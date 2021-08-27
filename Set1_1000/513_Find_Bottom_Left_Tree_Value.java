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
    int answer = 0;
    int height = 0;
    public int findBottomLeftValue(TreeNode root) {
        dfsHelper(root, 1);
        return answer;
    }
    
    public void dfsHelper(TreeNode node, int depth) {
        if (height < depth) {
            answer = node.val;
            height = depth;
        }
        if (node.left != null)
            dfsHelper(node.left, depth + 1);
        if (node.right != null)
            dfsHelper(node.right, depth + 1);
    }
}
