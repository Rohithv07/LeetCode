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
    public int averageOfSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int [] countSubtree = new int [1];
        inorder(root, countSubtree);
        return countSubtree[0];
    }
    
    // left[0] stores the sum of left subtree, left[1] stores number of nodes present there
    private int [] inorder(TreeNode node, int [] countSubtree) {
        if (node == null) {
            return new int []{0, 0};
        }
        int [] left = inorder(node.left, countSubtree);
        int [] right = inorder(node.right, countSubtree);
        int currentSubtreeSum = left[0] + right[0] + node.val;
        int totalNodes = left[1] + right[1] + 1; // + 1 means the current node
        int average = currentSubtreeSum / totalNodes;
        if (average == node.val) {
            countSubtree[0]++;
        }
        return new int []{currentSubtreeSum, totalNodes};
    }
}