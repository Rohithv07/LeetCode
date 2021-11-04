// bfs
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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 0;
        }
        Queue<StateOfLeaf> queue = new LinkedList<>();
        queue.offer(new StateOfLeaf(root, false));
        int sumOfLeftLeaves = 0;
        while (!queue.isEmpty()) {
            int size =queue.size();
            for (int i=0; i<size; i++) {
                StateOfLeaf current = queue.poll();
                TreeNode currentNode = current.node;
                if (current.isLeftLeaf && currentNode.left == null && currentNode.right == null) {
                    sumOfLeftLeaves += current.node.val;
                    //continue;
                }
                if (currentNode.left != null) {
                    queue.offer(new StateOfLeaf(currentNode.left, true));
                }
                if (currentNode.right != null) {
                    queue.offer(new StateOfLeaf(currentNode.right, false));
                }
            }
        }
        return sumOfLeftLeaves;
    }
}

class StateOfLeaf {
    TreeNode node;
    boolean isLeftLeaf;
    StateOfLeaf(TreeNode node, boolean isLeftLeaf) {
        this.node = node;
        this.isLeftLeaf = isLeftLeaf;
    }
}



// dfs

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
// dfs solution
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int result = 0;
        if (isLeaf(root.left)) {
            result += root.left.val;
        }
        else {
            result += sumOfLeftLeaves(root.left);
        }
        result += sumOfLeftLeaves(root.right);
        return result;
    }
    
    private boolean isLeaf(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}