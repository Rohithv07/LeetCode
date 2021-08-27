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
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int [] count = new int [1];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        dfsHelper(root, 0, sum, map, count);
        return count[0];
    }
    
    public void dfsHelper(TreeNode node, int currentSum, int sum, Map<Integer, Integer> map, int [] count) {
        if (node == null)
            return;
        currentSum += node.val;
        if (map.containsKey(currentSum - sum))
            count[0] += map.get(currentSum - sum);
        map.put(currentSum, map.getOrDefault(currentSum, 0) + 1);
        dfsHelper(node.left, currentSum, sum, map, count);
        dfsHelper(node.right, currentSum, sum, map, count);
        map.put(currentSum, map.get(currentSum) - 1);
    }
}
