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

// // O(n ^ 2)
// class Solution {
//     public TreeNode bstFromPreorder(int[] preorder) {
//         if (preorder == null || preorder.length == 0)
//             return new TreeNode();
//         TreeNode root = new TreeNode(preorder[0]);
//         for (int i=1; i<preorder.length; i++) {
//             buildTree(root, preorder[i]);
//         }
//         return root;
//     }
    
//     public TreeNode buildTree(TreeNode root, int key) {
//         if (root == null) {
//             return root = new TreeNode(key);
//         }
//         if (root.val > key)
//             root.left = buildTree(root.left, key);
//         else
//             root.right = buildTree(root.right, key);
//         return root;
//     }
// }


// o(n)
class Solution {
    int currentIndex = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0)
            return new TreeNode();
        return buildTree(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode buildTree(int [] preorder, int maxBound) {
        if (currentIndex == preorder.length || preorder[currentIndex] > maxBound) {
            return null;
        }
        int currentValue = preorder[currentIndex++];
        TreeNode root = new TreeNode(currentValue);
        // root left right
        root.left = buildTree(preorder, currentValue);
        root.right = buildTree(preorder, maxBound);
        return root;
    }
}
    
    

// also another solution using lower and upper bound

class Solution {
     int currentIndex = 0;
     public TreeNode bstFromPreorder(int[] preorder) {
         if (preorder == null || preorder.length == 0)
             return new TreeNode();
         return buildTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
     }
     
     public TreeNode buildTree(int [] preorder, int lowerBound, int upperBound) {
         if (currentIndex == preorder.length || preorder[currentIndex] < lowerBound || preorder[currentIndex] > upperBound) {
             return null;
         }
         int currentValue = preorder[currentIndex++];
         TreeNode root = new TreeNode(currentValue);
         root.left = buildTree(preorder, lowerBound, currentValue);
         root.right = buildTree(preorder, currentValue, upperBound);
         return root;
     }
 }
    
    
