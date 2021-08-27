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

/*
Recursively look for the node with no grandchildren and both left and right child in the left sub-tree. Then store node->right in temp and make node->right=node->left. Insert temp in first node NULL on right of node by node=node->right. Repeat until it is converted to linked list. 

*/
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;
        if (root.left != null) {
            flatten(root.left);
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            // now find the position to insert it
            TreeNode current = root.right;
            while (current.right != null)
                current = current.right;
            current.right = temp;
        }
        flatten(root.right);
    }
}
