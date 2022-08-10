class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // base case will be if 0 is already restricted
        // my idea is to mark the restricted nodes as visited in a boolean array so that it does not conflict with our recursion
        // then build the graph from the given edges matrix and do a simple dfs from the starting node 0.
        // increment the counter whenever we are able to make a move further
        // if we already gets visited, it means either the node is visited before or its been marked as restricted becuase we are using same visited array to track both.
        boolean [] visited = new boolean [n];
        for (int restrict : restricted) {
            visited[restrict] = true;
        }
        if (visited[0]) {
            return 0;
        }
        List<List<Integer>> graph = buildGraph(n, edges);
        return findAllReachables(graph, visited, n, 0);
    }
    
    private int findAllReachables(List<List<Integer>> graph, boolean [] visited, int n, int node) {
        if (visited[node]) {
            return 0;
        }
        int count = 1;
        visited[node] = true;
        List<Integer> children = graph.get(node);
        for (Integer child : children) {
            if (!visited[child]) {
                count += findAllReachables(graph, visited, n, child);
            }
        }
        return count;
    }
    
    private List<List<Integer>> buildGraph(int n, int [][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int [] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        return graph;
    }
}