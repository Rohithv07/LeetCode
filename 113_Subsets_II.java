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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(result, root, current, targetSum, 0);
        return result;
    }
    
    public void dfs(List<List<Integer>> result, TreeNode node, List<Integer> current, int targetSum, int currentSum) {
        if (node == null)
            return;
        current.add(node.val);
        if (node.left == null && node.right == null && currentSum + node.val == targetSum) {
            result.add(new ArrayList<>(current));
            current.remove(current.size() - 1);
            return;
        }
        System.out.println(current);
        if (node.left != null) {
            dfs(result, node.left, current, targetSum, currentSum + node.val);
        }
        if (node.right != null) {
            dfs(result, node.right, current, targetSum, currentSum + node.val);
        }
        current.remove(current.size() - 1);
    }
}