// https://leetcode.com/problems/sum-of-distances-in-tree/discuss/885637/Java-solution-code-%2B-photo-explaination

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 0) {
            return new int []{};
        }
        if (n == 1 && edges.length == 0) {
            return new int []{0};
        }
        Map<Integer, List<Integer>> graph = buildGraph(edges);
        int [] count = new int [n];
        int [] result = new int [n];
        Arrays.fill(count, 1);
        // first do postorder so that we get the distance for 0 th node
        // count[node] += count[child]
        // result[node] += result[child] + count[child]
        postOrder(0, -1, graph, count, result);
        // to get the rest of the answer, do a post order
        // result[child] = result[node] + (n - count[child]) - count[child];
        preOrder(0, -1, graph, count, result, n);
        return result;
    }
    
    public void postOrder(int node, int parent, Map<Integer, List<Integer>> graph, int [] count, int [] result) {
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                postOrder(child, node, graph, count, result);
                count[node] += count[child];
                result[node] += result[child] + count[child];
            }
        }
    }
    
    public void preOrder(int node, int parent, Map<Integer, List<Integer>> graph, int [] count, int [] result, int n) {
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (child != parent) {
                result[child] = result[node] + (n - count[child]) - count[child];
                preOrder(child, node, graph, count, result, n);
            }
        }
    }
    
    public Map<Integer, List<Integer>> buildGraph(int [][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int [] edge : edges) {
            graph.computeIfAbsent(edge[0], x -> new ArrayList<>()).add(edge[1]);
            graph.computeIfAbsent(edge[1], x -> new ArrayList<>()).add(edge[0]);
        }
        return graph;
    }
}