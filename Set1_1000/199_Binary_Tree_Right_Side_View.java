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

// take only one node from the tree from each depth. ALways take from the right if possible, otherwise change according to the availablity
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<Integer> rightSide = new ArrayList<>();
        showRightSideView(rightSide, root, 0);
        return rightSide;
    }
    public void showRightSideView(List<Integer> rightSide, TreeNode node, int depth) {
        if (node == null)
            return;
        if (depth == rightSide.size()) {
            rightSide.add(node.val);
        }
        showRightSideView(rightSide, node.right, depth + 1);
        showRightSideView(rightSide, node.left, depth + 1);
    }
}



// both dfs and bfs in a single pgm

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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        levelOrder(root, result);
        dfs(root, 0, result);
        return result;
    }
    
    private void dfs(TreeNode node, int level, List<Integer> result) {
        if (result.size() == level) {
            result.add(node.val);
        }
        if (node.right != null) {
            dfs(node.right, level + 1, result);
        }
        if (node.left != null) {
            dfs(node.left, level + 1, result);
        }
    }
    
    private void levelOrder(TreeNode node, List<Integer> result) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                TreeNode currentNode = queue.poll();
                if (i == size - 1) {
                    result.add(currentNode.val);
                }
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
        }
    }
}