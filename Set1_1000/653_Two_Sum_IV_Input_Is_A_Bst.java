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
    public boolean findTarget(TreeNode root, int k) {
       if (root == null)
            return false;
        Set<Integer> set = new HashSet<>();
        return dfs(root, set, k);
    }
    
    public boolean dfs(TreeNode root, Set<Integer> set, int target) {
        if (root == null)
            return false;
        if (set.contains(target - root.val))
            return true;
        set.add(root.val);
        return dfs(root.left, set, target) || dfs(root.right, set, target);
    }
}
