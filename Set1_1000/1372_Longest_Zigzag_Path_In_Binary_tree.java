/*
My thought process:
So here we need to move in a zig zag fashion through the tree, and find the maximum depth from any of the node in zig zag fashion.
So we can start from the root node, do the search on the left or right and we also need to have a varibale to keep track whether we are currently in left or right becuase if we are now at a left node, then we have to move to the right, not continue with the left child. So we need to keep track of the direction and continue the work. Thats it and a simple dfs recursive will do the work.

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
    int max = 0; //Each node's value is between [1, 100].
    public int longestZigZag(TreeNode root) {
        if (root == null)
            return 0;
        dfs(root.left, 0, false);    // let false be for left and true be for right
        dfs(root.right, 0, true);
        return max;
    }
    public void dfs(TreeNode node, int depth, boolean directionLeftOrRight) {
        max = Math.max(max, depth);
        if (node == null)
            return;
        dfs(node.left, (directionLeftOrRight) ? depth+1:0, false);
        dfs(node.right, (!directionLeftOrRight) ? depth+1:0, true);
    }
}
