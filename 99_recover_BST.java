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
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode first = null;
        TreeNode second = null;
        TreeNode temp = null;
        // morris traversal
        while (root != null) {
            if (root.left != null) {
                temp = root.left;
                while (temp.right != null && temp.right != root) 
                    temp = temp.right;
                if (temp.right != null) {
                    if (pre != null && pre.val > root.val) {
                        if (first == null) 
                            first = pre;
                        second = root;
                    }
                    pre = root;
                    temp.right = null;
                    root = root.right;
                }
                else {
                    temp.right = root;
                    root = root.left;
                }
            }
            else {
                if (pre != null && pre.val > root.val) {
                    if (first == null)
                        first = pre;
                    second = root;
                }
                pre = root;
                root = root.right;
            }
        }
        // swap the node values
        if (first != null && second != null) {
            int t = first.val;
            first.val = second.val;
            second.val = t;
        }
    }
}
