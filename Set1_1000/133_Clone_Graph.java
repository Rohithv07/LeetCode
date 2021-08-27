/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
       if (node == null)
           return null;
        Map<Integer, Node> map = new HashMap<>();
        return dfsCloneHelper(node, map);
    }
    public Node dfsCloneHelper(Node node, Map<Integer, Node> map){
        if (map.containsKey(node.val))
            return map.get(node.val);
        Node currentNode = new Node(node.val);
        map.put(node.val, currentNode);
        for (Node neighbors: node.neighbors) {
            currentNode.neighbors.add(dfsCloneHelper(neighbors, map));
        }
        return currentNode;
    }
}
