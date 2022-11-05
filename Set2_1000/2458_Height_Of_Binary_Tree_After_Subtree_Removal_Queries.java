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
    
    private int [] preorderHeight = new int[100001];
    private int [] postorderHeight = new int[100001];
    
    private int max;
    // postorder and preorder cover the right and left and take the maximum
    public int[] treeQueries(TreeNode root, int[] queries) {
        max = 0;
        preorder(root, 0);
        max = 0;
        postorder(root, 0);
        int length = queries.length;
        int [] result = new int [length];
        for (int i = 0; i < length; i++) {
            result[i] = Math.max(preorderHeight[queries[i]], postorderHeight[queries[i]]);
        }
        return result;
    }
    
    private void preorder(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        preorderHeight[node.val] = max;
        max = Math.max(max, height);
        preorder(node.left, height + 1);
        preorder(node.right, height + 1);
    }
    
    private void postorder(TreeNode node, int height) {
        if (node == null) {
            return;
        }
        postorderHeight[node.val] = max;
        max = Math.max(max, height);
        postorder(node.right, height + 1);
        postorder(node.left, height + 1);
    }
}