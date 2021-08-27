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
    int result;
    Set<TreeNode> trackParentAndVisited;
    public int minCameraCover(TreeNode root) {
        // our initial result is 0
        result = 0;
        trackParentAndVisited = new HashSet<>();
        // our current root have no parent
        // add null to set
        trackParentAndVisited.add(null);
        // do the dfs traversal on root along with its parent null
        dfs(root, null);
        return result;
    }
    
    public void dfs(TreeNode node, TreeNode parent) {
        // continue if the node is not null 
        if (node != null) {
            // do the dfs on left and right keeping node as the new parent
            dfs(node.left, node);
            dfs(node.right, node);
            // if our parent is null and node, node.lefy and node.right is not visited or tracked, update our result by 1
            if (parent == null && !trackParentAndVisited.contains(node) || !trackParentAndVisited.contains(node.left) || !trackParentAndVisited.contains(node.right)) {
                // increment the result
                result += 1;
                // add all the parent, node, node.left and right onto the set
                trackParentAndVisited.add(node);
                trackParentAndVisited.add(node.left);
                trackParentAndVisited.add(node.right);
                trackParentAndVisited.add(parent);
            }
        }
    }
}
