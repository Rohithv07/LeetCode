/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// Recursive Solution

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        helper(root, result);
        return result;
    }
    
    public void helper(Node node, List<Integer> result) {
        if (node == null)
            return;
        result.add(node.val);
        for (Node n : node.children) {
            helper(n, result);
        }
    }
}



// iterative
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            result.add(root.val);
            for (int i=root.children.size() - 1; i>=0; i--) {
                stack.add(root.children.get(i));
            }
        }
        return result;
    }
}
