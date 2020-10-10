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
    static long sum;
    static long maxProd;
    // here we make use of dfs to find the total sum of the whole binary tree
    public static void dfs(TreeNode root) {
        if(root == null) return;
        sum += (long)root.val;
        dfs(root.left);
        dfs(root.right);
    }
    // here we update the maxproduct with currentprod and prod(left+right+val) * (sum - left - right - val)
    public static long checkMax(TreeNode root) {
        if(root == null) return 0;
        long l = checkMax(root.left);
        long r = checkMax(root.right);
        maxProd = Math.max(maxProd, (l + r + root.val) * (sum - l - r - root.val));
        return l + r + root.val;
    }
    // this function return the maximum possible result
    public int maxProduct(TreeNode root) {
        sum = 0;
        maxProd = 0;
        dfs(root);
        long rootProd = checkMax(root);
        return (int)(maxProd % ((int)Math.pow(10, 9) + 7));
    }
}
