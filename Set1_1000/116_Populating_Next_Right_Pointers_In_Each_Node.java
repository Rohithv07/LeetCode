/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/


// 1. Extra space
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        // we add root and null
        queue.offer(root);
        queue.offer(null);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            // 1st case we reached the end of the tree
            if (current == null && queue.isEmpty())
                return root;
            // 2nd if we reached particular position of the tree but not the end
            else if (current == null) {
                // then add null to the queue
                queue.offer(null);
                continue;
            }
            // 3rd we want to set the next pointer for the current to the first element of the queue
            // and add the elements left and right child on to the queue
            else {
                current.next = queue.peek();
                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return root;
    }
}


// Constant space
class Solution {
    public Node connect(Node root) {
        if (root == null)
            return null;
        // we make use of 2 variable of type Node both initialy pointing to root
        Node start = root;
        Node left = root;
        while(start.left != null) {
            while (start != null) {
                start.left.next = start.right;
                if (start.next != null)
                    start.right.next = start.next.left;
                start = start.next;
            }
            start = left.left;
            left = start;
        }
        return root;
    }
}



/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node previous = null;
        Node veryEndLevel = root;
        Node nextEnd = null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                queue.offer(current.left);
                nextEnd = current.left;
            }
            if (current.right != null) {
                queue.offer(current.right);
                nextEnd = current.right;
            }
            if (previous != null) {
                previous.next = current;
            }
            if (veryEndLevel == current) {
                current.next = null;
                previous = null;
                veryEndLevel = nextEnd;
            }
            else {
                previous = current;
            }
        }
        return root;
    }
}
