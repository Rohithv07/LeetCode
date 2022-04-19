// inorder using recursion

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
    private TreeNode first;
    private TreeNode second;
    private TreeNode previous;
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        if (first == null && previous != null && node.val < previous.val) {
            first = previous;
        }
        if (first != null && node.val < previous.val) {
            second = node;
        }
        previous = node;
        inorder(node.right);
    }
}




// optimised

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
