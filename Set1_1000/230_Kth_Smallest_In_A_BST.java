
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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack();
        int result = -Integer.MIN_VALUE;
        int count = 0;
        while(count != k){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            result = root.val;
            count += 1;
            root = root.right;
        }
        return result;
    }
}




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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> result =  inOrderTraversal(root, new ArrayList<Integer>());
        return result.get(k - 1);
    }
     public ArrayList<Integer> inOrderTraversal(TreeNode root, ArrayList<Integer> array) {
         if (root == null)
             return null;
         inOrderTraversal(root.left, array);
         array.add(root.val);
         inOrderTraversal(root.right, array);
         return array;
     }
}


// using priorityQueue

class Solution {
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        inorderTraversal(root, pq, k);
        return pq.poll();
    }
    
    public void inorderTraversal(TreeNode node, PriorityQueue<Integer> pq, int k) {
        if (node == null)
            return;
        pq.add(node.val);
        if (pq.size() > k)
            pq.remove();
        inorderTraversal(node.left, pq, k);
        inorderTraversal(node.right, pq, k);
    }
}

// another efficient solution using recursion

class Solution {
    private int result = -1;
    private int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if (root == null)
            return -1;
        inOrder(root, k);
        return result;
    }
    
    public void inOrder(TreeNode node, int k) {
        if (node == null)
            return;
        inOrder(node.left, k);
        count += 1;
        if (count == k) {
            result = node.val;
            return;
        }
        inOrder(node.right, k);
    }
}