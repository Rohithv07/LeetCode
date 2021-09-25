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

// steps followed

// 1. The last element in post order will be the root of the tree
// 2. find the corresponding index of root in inorder
// 3. So all the elements to the left side of the root index in inorder will be left subtree
// 4. All the elements to the right side of the root index in inorder willl be right subtree
// 5. do recursion for the right subtree
// 6. do recursion for the left subtree. the left child in post order will be at postIndex - inEnd - 1 + rootIndexInInOrder
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return constructTree(postorder.length - 1, 0, inorder.length - 1, inorder, postorder);
    }
    
    public TreeNode constructTree(int postIndex, int inStart, int inEnd, int [] inorder, int [] postorder) {
        if (postIndex < 0 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[postIndex]);
        int rootIndex = -1;
        for (int i=inStart; i<=inEnd; i++) {
            if (postorder[postIndex] == inorder[i]) {
                rootIndex = i;
                break;
            }
        }
        root.right = constructTree(postIndex-1, rootIndex + 1, inEnd, inorder, postorder);
        root.left = constructTree(postIndex - inEnd - 1 + rootIndex, inStart, rootIndex - 1, inorder, postorder);
        return root;
    }
}