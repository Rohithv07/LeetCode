/* My thought proces

Here we can do a simple dfs  on both original and cloned, then checking if original node === target, if yes return the cloned as we have to do so else we continue to do the dfs Search...


*/
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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if (original == null || original == target)
            return cloned;
        TreeNode result = getTargetCopy(original.left, cloned.left, target);
        if (result != null)
            return result;
        return getTargetCopy(original.right, cloned.right, target);  
    }
}
