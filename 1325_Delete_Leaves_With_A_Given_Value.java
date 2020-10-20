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

// Here the idea is simple, we just do a depth first search to the leaf node and checks whether there is left and right = null
// and the current value = target, if so we return null.
// we continue this for newly created leaf and also delete them if its value = target.
// finalyy return the root.
class Solution {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root == null)
            return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null)
            return null;
        return root;
    }
}

// O(depthOftree)
