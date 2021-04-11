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
    public int deepestLeavesSum(TreeNode root) {
        // here we can do BFS and we can find the sum of the deepest leaves easier
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int sum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            // we reset the sum after each level and the value at the last will be the total sum after reaching the deep deep leaf node
            sum = 0;
            while (size-- > 0) {
                TreeNode current = queue.poll();
                sum += current.val;
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return sum;
    }
}


// some other method using dfs alone and using both dfs(to find height) and bfs.

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
    public int deepestLeavesSum(TreeNode root) {
        if (root == null)
            return 0;
        int [] deepest = new int [] {0};
        int [] sum = new int [] {0};
        dfsHelper(root, 0, deepest, sum);
        return sum[0];
    }
    
    public void dfsHelper(TreeNode node, int currentLevel, int [] deepest, int [] sum) {
        if (node == null)
            return;
        if (currentLevel > deepest[0]) {
            deepest[0] = currentLevel;
            sum[0] = 0;
        }
        if (currentLevel == deepest[0]) {
            sum[0] += node.val;
        }
        dfsHelper(node.left, currentLevel + 1, deepest, sum);
        dfsHelper(node.right, currentLevel + 1, deepest, sum);
    }
    
    
      //  this is mix of dfs and bfs
        if (root == null)
            return 0;
        int height = findHeight(root);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentLevel = 0;
        int sum = 0;
        while (!queue.isEmpty()) {
            currentLevel += 1;
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode current = queue.poll();
                if (currentLevel == height) {
                    sum += current.val;
                }
                else {
                    if (current.left != null)
                        queue.add(current.left);
                    if (current.right != null)
                        queue.add(current.right);
                }
            }
        }
        return sum;
    }
    
    public int findHeight(TreeNode node) {
        if (node == null)
            return 0;
        return 1 + Math.max(findHeight(node.left), findHeight(node.right));
    }
    
}
