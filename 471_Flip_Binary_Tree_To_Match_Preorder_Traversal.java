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
    List<Integer> result = new ArrayList<>();
    int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        return dfsHelper(root, voyage) ? result : Arrays.asList(-1);
    }
    
    public Boolean dfsHelper(TreeNode node, int [] voyage) {
        if (node == null)
            return true;
        if (node.val != voyage[index++]) {
            return false;
        }
        if (node.left != null && node.left.val != voyage[index]) {
            result.add(node.val);
            return dfsHelper(node.right, voyage) && dfsHelper(node.left, voyage);
        }
        return dfsHelper(node.left, voyage) && dfsHelper(node.right, voyage);
    }
}
