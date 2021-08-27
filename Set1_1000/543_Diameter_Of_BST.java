// 0ms approach

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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int[] max = new int [1];
        findHeight(root, max);
        return max[0];
    }
    
    public int findHeight(TreeNode node, int [] max) {
        if (node == null)
            return 0;
        int leftHeight = findHeight(node.left, max);
        int rightHeight = findHeight(node.right, max);
        max[0] = Math.max(max[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }
}



// 9ms

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
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = findHeight(root.left);
        int rightHeight = findHeight(root.right);
        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }
    
    public int findHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
}

