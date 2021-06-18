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

// this is O(n^2), O(n) is available in discuss session
class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<TreeNode> duplicates = new ArrayList<>();
        postOrderHelper(root, new HashMap<>(), duplicates);
        return duplicates;
    }
    
    public String postOrderHelper(TreeNode node, Map<String, Integer> map, List<TreeNode> duplicates) {
        if (node == null)
            return "#";
        StringBuilder id = new StringBuilder();
        id.append(node.val);
        id.append(",");
        id.append(postOrderHelper(node.left, map, duplicates));
        id.append(",");
        id.append(postOrderHelper(node.right, map, duplicates));
        map.put(id.toString(), map.getOrDefault(id.toString(), 0) + 1);
        if (map.get(id.toString()) == 2)
            duplicates.add(node);
        return id.toString();
    }
}
