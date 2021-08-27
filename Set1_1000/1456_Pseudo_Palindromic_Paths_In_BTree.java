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

// check for atmost 1 odd occurance
class Solution {
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> set = new HashSet<>();
        return dfs(root, set);
    }
    public int dfs(TreeNode node, Set<Integer> set) {
        if (node == null)
            return 0;
        if (set.contains(node.val))
            set.remove(node.val);
        else
            set.add(node.val);
        int count = 0;
        if (node.left == null && node.right == null && set.size() <= 1)
            count += 1;
        count += dfs(node.left, new HashSet<>(set)) + dfs(node.right, new HashSet<>(set));
        //if (set.contains(node.val)) / *
        //    set.remove(node.val);      These commented code is also correct but need to change the recursive call like fun(node.left, set)
        //else  			
        //    set.add(node.val);       */
        return count;
        
    }
}
