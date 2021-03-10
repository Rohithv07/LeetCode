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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        // helper function
        insert(v, root, 1, d);
        return root;
    }
    
    public void insert(int val, TreeNode root, int depth, int d) {
        if (root == null)
            return;
        if (depth == d - 1) {
            TreeNode node = root.left;
            root.left = new TreeNode(val);
            root.left.left = node;
            node = root.right;
            root.right = new TreeNode(val);
            root.right.right = node;
        }
        else {
            insert(val, root.left, depth + 1, d);
            insert(val, root.right, depth + 1, d);
        }
    }
}