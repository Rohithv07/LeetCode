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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int result = -Integer.MIN_VALUE;
        int count = 0;
        while(count != k){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result = root.val;
            count += 1;
            root = root.right;
        }
        return result;
    }
}
