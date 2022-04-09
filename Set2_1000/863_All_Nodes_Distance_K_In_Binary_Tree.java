/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> nodeToParent = new HashMap<>();
        Set<TreeNode> visited = new HashSet<>();
        fillNodeToParent(root, null, nodeToParent);
        fillResult(target, k, 0, result, visited, nodeToParent);
        return result;
    }
    
    private void fillNodeToParent(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> nodeToParent) {
        if (node == null) {
            return;
        }
        nodeToParent.put(node, parent);
        fillNodeToParent(node.left, node, nodeToParent);
        fillNodeToParent(node.right, node, nodeToParent);
    }
    
    private void fillResult(TreeNode node, int k, int currentK, List<Integer> result, Set<TreeNode> visited, Map<TreeNode, TreeNode> nodeToParent) {
        if (node == null) {
            return;
        }
        if (currentK > k) {
            return;
        }
        if (visited.contains(node)) {
            return;
        }
        if (currentK == k) {
            result.add(node.val);
        }
        visited.add(node);
        fillResult(node.left, k, currentK + 1, result, visited, nodeToParent);
        fillResult(node.right, k, currentK + 1, result, visited, nodeToParent);
        fillResult(nodeToParent.get(node), k, currentK + 1, result, visited, nodeToParent);
    }
}